package cn.yaspeed.ssm.controller;

import cn.yaspped.ssm.service.IPermissionService;
import cn.yasspeed.ssm.domain.Permission;
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
 * @date 2020/5/7 17:41
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService ;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue="1")Integer page, @RequestParam(name = "size",required = true, defaultValue="4")Integer size){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page,size);
        PageInfo<Permission> permissionPageInfo=new PageInfo<>(permissionList);
        mv.addObject("permissionList",permissionPageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv = new ModelAndView();
        Permission permission =permissionService.findById(id);
        mv.setViewName("permission-show");
        mv.addObject("permission",permission);
        return mv;
    }
}
