package cn.yaspped.ssm.service.imp;

import cn.yaspped.ssm.dao.ISysLogDao;
import cn.yaspped.ssm.service.ISysLogService;
import cn.yasspeed.ssm.domain.SysLog;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/5/8 18:17
 */
@Service
@Transactional
public class SysLogServiceImp implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
