package cn.yaspped.ssm.service;

import cn.yasspeed.ssm.domain.Orders;
import cn.yasspeed.ssm.domain.Product;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/4/18 21:39
 */
public interface IProductService {

    /**
     * 查询所有产品
     *
     * @return
     */
    public List<Product> findAll(int page, int size);

    /**
     * 添加新产品
     *
     * @param product
     */
    public void save(Product product);

    /**
     * 根据id查询产品信息
     *
     * @param id
     * @return
     */
    public Product findById(String id);

    /**
     * 修改产品信息
     * @param product
     * @return
     */
    public void edit(Product product);

    /**
     * 根据id查询产品下的订单
     * @param id
     * @return
     */
    public List<Orders> findOrderById(String id);
}
