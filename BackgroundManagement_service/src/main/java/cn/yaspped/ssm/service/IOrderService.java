package cn.yaspped.ssm.service;

import cn.yasspeed.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {
    /**
     * 查询所有订单
     * @return
     */
    public List<Orders> findAll(int page,int size);

     public Orders findById(String id);
}
