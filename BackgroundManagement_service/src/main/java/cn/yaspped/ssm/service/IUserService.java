package cn.yaspped.ssm.service;

import cn.yasspeed.ssm.domain.Role;
import cn.yasspeed.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserInfo> findAll(int page,int size);

    /**
     * 保存一个新的用户
     * @param userInfo
     */
    void save(UserInfo userInfo);

    /**
     * 根据id，查找用户详情
     * @param id
     * @return
     */
    UserInfo findById(String id);

    /**
     * 根据用户id查询可以添加的角色
     * @param id
     * @return
     */
    List<Role> findOthersRoles(String id);

    /**
     * 给用户添加新的角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds);
}
