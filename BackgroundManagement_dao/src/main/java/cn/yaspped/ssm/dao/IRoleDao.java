package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Permission;
import cn.yasspeed.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId =#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.yaspped.ssm.dao.IPermissionDao.findPermissionsByRoleId")),
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) value(#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select("select * from role where id =#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "users", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.yaspped.ssm.dao.IUserDao.findUserByRoleId")),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.yaspped.ssm.dao.IPermissionDao.findPermissionsByRoleId"))
    }
    )
    public Role findById(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId =#{id}) ")
    public List<Permission> findRoleByIdAndAllPermission(String id);

    @Insert("insert into role_permission(permissionId,roleId)value(#{permissionId},#{roleId})")
    public void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
