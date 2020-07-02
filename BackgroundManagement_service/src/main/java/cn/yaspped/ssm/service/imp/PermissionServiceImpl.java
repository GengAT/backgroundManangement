package cn.yaspped.ssm.service.imp;

import cn.yaspped.ssm.dao.IPermissionDao;
import cn.yaspped.ssm.service.IPermissionService;
import cn.yasspeed.ssm.domain.Permission;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/5/7 17:43
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }
}
