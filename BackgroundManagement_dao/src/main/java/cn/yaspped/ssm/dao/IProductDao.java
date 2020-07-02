package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
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
}
