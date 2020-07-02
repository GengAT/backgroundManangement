package cn.yaspped.ssm.service.imp;

import cn.yaspped.ssm.dao.IOrderDao;
import cn.yaspped.ssm.service.IOrderService;
import cn.yasspeed.ssm.domain.Orders;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/4/19 20:18
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao iOrderDao;
    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return iOrderDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return iOrderDao.findById(id);
    }
}
