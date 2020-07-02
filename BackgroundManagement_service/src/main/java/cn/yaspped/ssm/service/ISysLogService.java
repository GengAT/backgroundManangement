package cn.yaspped.ssm.service;

import cn.yasspeed.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    /**
     * 保存操作日志信息
     * @param sysLog
     */
    public void save(SysLog sysLog);

    /**
     * 查询操作信息（日志）
     * @return
     */
   public List<SysLog> findAll(int page,int size);
}
