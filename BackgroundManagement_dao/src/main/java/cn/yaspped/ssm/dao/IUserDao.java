package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Role;
import cn.yasspeed.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.yaspped.ssm.dao.IRoleDao.findRoleByUserId"))
    }
    )
    public UserInfo findByUsername(String username);

    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.yaspped.ssm.dao.IRoleDao.findRoleByUserId"))
    }
    )
    public UserInfo findById(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId =#{id})")
    public List<Role> findOthersRoles(String id);


    @Insert("insert into users_role(userId,roleId)value(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    @Select("select * from users where id in(select userId from users_role where roleId=#{id})")
    public List<UserInfo> findUserByRoleId(String id);
}
