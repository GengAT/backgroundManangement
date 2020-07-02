package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Member;
import cn.yasspeed.ssm.domain.Orders;
import cn.yasspeed.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderTimeStr",column = "orderTimeStr"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "payTypeStr",column = "payTypeStr"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.yaspped.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll();

    @Select("select * from orders where id =#{orderId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderTimeStr",column = "orderTimeStr"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "payTypeStr",column = "payTypeStr"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.yaspped.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "cn.yaspped.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "cn.yaspped.ssm.dao.ITravellerDao.findByOrdersId"))

    })
    Orders findById(String orderId);
}
