package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/4/22 17:04
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId);


}
