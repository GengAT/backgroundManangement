package cn.yaspeed.ssm.controller;

import cn.yaspped.ssm.service.IRoleService;
import cn.yasspeed.ssm.domain.Permission;
import cn.yasspeed.ssm.domain.Product;
import cn.yasspeed.ssm.domain.Role;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gms
 * @Version: 1.0
 * @date 2020/5/7 16:57
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue="1")Integer page,@RequestParam(name = "size",required = true, defaultValue="4")Integer size){
        List<Role> roles = roleService.findAll(page,size);
        PageInfo<Role> productPageInfo = new PageInfo<>(roles);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", productPageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String id) {

        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> permissionList = roleService.findRoleByIdAndAllPermission(id);
        mv.addObject("role", role);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }
}
