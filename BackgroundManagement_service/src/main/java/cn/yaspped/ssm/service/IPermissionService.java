package cn.yaspped.ssm.service;

import cn.yasspeed.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    /**
     * 查找所有权限信息
     * @return
     */
    List<Permission> findAll(int page,int size);

    /**
     * 添加一个权限
     * @param permission
     */
    void save(Permission permission);

    /**
     * 根据I的查询权限详情
     * @param id
     * @return
     */
    Permission findById(String id);
}
