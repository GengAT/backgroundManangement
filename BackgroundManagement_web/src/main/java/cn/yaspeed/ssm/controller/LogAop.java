package cn.yaspeed.ssm.controller;

import cn.yaspped.ssm.service.ISysLogService;
import cn.yasspeed.ssm.domain.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/5/8 17:23
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;


    private Date startTime;// 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod;//访问的方法

    /**
     * 前置通知
     *
     * @param jp
     */
    @Before("execution(* cn.yaspeed.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        startTime = new Date();// 访问的时间
        //获取访问的类
        executionClass = jp.getTarget().getClass();
        //获取访问的方法
        String methodName = jp.getSignature().getName();//获得访问的方法的名称
        Object[] args = jp.getArgs();// 获得访问的方法的参数
        if (args == null || args.length == 0) {
            // 方法无参数
            executionMethod = executionClass.getMethod(methodName);
        } else {
            // 方法有参数
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, classArgs);
        }
    }

    @After("execution(* cn.yaspeed.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {

        // 获取类上@RequestMapping对象
        if (executionClass != SysLogController.class) {
            RequestMapping annotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if (annotation != null) {
                // 获取方法上的@RequestMapping对象
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url = "";// 执行的链接
                    url = annotation.value()[0] + methodAnnotation.value()[0];
                    SysLog sysLog = new SysLog();
                    // 访问实出
                    Long executionTime = new Date().getTime() - startTime.getTime();
                    // 封装sysLog对象的属性
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    sysLog.setIp(request.getRemoteAddr());
                    sysLog.setUsername(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
                    sysLog.setMethod("[类名]" + executionClass.getName() + "[方法名]" + executionMethod.getName());
                    sysLog.setVisitTime(startTime);
                    sysLogService.save(sysLog);
                }
            }
        }
    }

}
