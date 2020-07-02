package cn.yaspped.ssm.service.imp;

import cn.yaspped.ssm.dao.IRoleDao;
import cn.yaspped.ssm.service.IRoleService;
import cn.yasspeed.ssm.domain.Permission;
import cn.yasspeed.ssm.domain.Role;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/5/7 17:00
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String id) {
        return roleDao.findRoleByIdAndAllPermission(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String id : ids) {
            roleDao.addPermissionToRole(roleId, id);
        }

    }
}
