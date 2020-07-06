package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductDao {
    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll();

    /**
     * 添加新产品
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);

    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    @Select("select * from product where id =#{id}")
    public Product findById(String id);

    /**
     * 根据id修改产品信息
     * @param product
     * @return
     */
    //productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id} ")
   public void edit(Product product);

}
