package cn.yaspped.ssm.service.imp;

import cn.yaspped.ssm.dao.IOrderDao;
import cn.yaspped.ssm.dao.IProductDao;
import cn.yaspped.ssm.service.IProductService;
import cn.yasspeed.ssm.domain.Orders;
import cn.yasspeed.ssm.domain.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/4/18 21:42
 */

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;
    @Autowired
    private IOrderDao iOrderDao;

    @Override
    public List<Product> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }

    @Override
    public Product findById(String id) {
        return iProductDao.findById(id);
    }

    @Override
    public void edit(Product product) {
        iProductDao.edit(product);
    }

    @Override
    public List<Orders> findOrderById(String id) {
        return iOrderDao.findOrderById(id);
    }
}
