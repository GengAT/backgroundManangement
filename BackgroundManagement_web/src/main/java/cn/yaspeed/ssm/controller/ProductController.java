package cn.yaspeed.ssm.controller;

import cn.yaspped.ssm.service.IProductService;
import cn.yasspeed.ssm.domain.Orders;
import cn.yasspeed.ssm.domain.Product;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/4/18 22:47
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue="1")Integer page,@RequestParam(name = "size",required = true, defaultValue="4")Integer size){
        ModelAndView mv =new ModelAndView();
        List<Product> all = productService.findAll(page,size);
        PageInfo<Product> productPageInfo = new PageInfo<>(all);
        mv.addObject("productPageInfo",productPageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv =new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-edit");
        return mv;
    }

    @RequestMapping("/edit.do")
    public String edit(Product product){
        ModelAndView mv =new ModelAndView();
        productService.edit(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findOrderById.do")
    public ModelAndView findOrderById(String id){
        ModelAndView mv =new ModelAndView();
        List<Orders> orders  = productService.findOrderById(id);
        mv.addObject("orders",orders);
        mv.setViewName("product_orders-show");
        return mv;
    }


}
