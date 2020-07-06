package cn.yaspeed.ssm.controller;

import cn.yaspped.ssm.service.IOrderService;
import cn.yasspeed.ssm.domain.Orders;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单管理
 * @author gms
 * @Version: 1.0
 * @date 2020/4/19 20:16
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size){
        List<Orders> orders = iOrderService.findAll(page,size);
        ModelAndView mv =new ModelAndView();
        //分页bean
        PageInfo<Orders> pageInfo =new PageInfo<>(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv =new ModelAndView();
        Orders orders = iOrderService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/findByIdForEdit.do")
    public ModelAndView findByIdForEdit(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv =new ModelAndView();
        Orders orders = iOrderService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-edit");
        return mv;
    }
}
