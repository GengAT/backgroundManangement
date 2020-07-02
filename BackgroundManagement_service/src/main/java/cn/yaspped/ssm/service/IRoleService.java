package cn.yaspped.ssm.service;

import cn.yasspeed.ssm.domain.Permission;
import cn.yasspeed.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<Role> findAll(int page,int size);

    /**
     * 保存新角色
     *
     * @param role
     */
    public void save(Role role);

    /**
     * 根据id查询角色
     *
     * @param id
     * @return
     */
    public Role findById(String id);

    /**
     * 根据id查询未被授予的权限
     * @param id
     * @return
     */
    List<Permission> findRoleByIdAndAllPermission(String id);

    /**
     * 根据roleId添加新权限
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(String roleId, String[] ids);
}
