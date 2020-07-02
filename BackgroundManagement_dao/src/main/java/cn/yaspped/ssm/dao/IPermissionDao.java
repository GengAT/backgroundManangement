package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId =#{id})")
    public List<Permission> findPermissionsByRoleId(String id);

    @Select("select * from permission")
    public List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) value(#{permissionName},#{permissionName})")
    public void save(Permission permission);

    @Select("select * from permission where id =#{id}")
    Permission findById(String id);
}
