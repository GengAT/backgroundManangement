package cn.yaspeed.ssm.controller;

import cn.yaspped.ssm.service.ISysLogService;
import cn.yasspeed.ssm.domain.SysLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/5/8 18:03
 */
@RequestMapping("/sysLog")
@Controller
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue="1")Integer page, @RequestParam(name = "size",required = true, defaultValue="4")Integer size){
        ModelAndView mv =new ModelAndView();
        List<SysLog> logs =sysLogService.findAll(page,size);
        PageInfo<SysLog> sysLogPageInfo =new PageInfo<>(logs);
        mv.addObject("sysLogs",sysLogPageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
