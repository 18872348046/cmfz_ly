package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping("/login")
    public String adminLogin(Admin admin, HttpSession session, String enCode){
        /*根据用户输入的用户名查询admin*/
       Admin md5User=adminService.findUsername(admin.getName());
       /*获取数据库用MD5加密之后的密码*/
        String salt=md5User.getSalt();

        /*加密用户刚刚输入的密码*/
        String pwd=DigestUtils.md5Hex(salt+admin.getPassword());

        admin.setPassword(pwd);

        Admin admins=adminService.findLogin(admin);
        //强制登陆
        session.setAttribute("admins",admins);
        //获取验证码
       String stringCode=session.getAttribute("code").toString();

        if(stringCode.equalsIgnoreCase(enCode) && admins!=null){
            return "redirect:/back/admin/main/main.jsp";
        }else{
            return "redirect:/back/admin/login.jsp";
        }
    }
    //修改密码
    @RequestMapping("/pwd")
    public @ResponseBody Map<String,Object> pwdAdmin(Admin admin,HttpSession session,String password1,String password3){
        /*password1:原密码，password3：确认新密码*/
        Map<String,Object> map=new HashMap<String,Object>();
        Admin ad=(Admin)session.getAttribute("admins");

        /*根据用户输入的用户名查询admin*/
        Admin md5User=adminService.findUsername(ad.getName());
        /*获取数据库用MD5加密之后的密码*/
        String salt=md5User.getSalt();
        /*加密刚刚输入的确认新密码
        String pwd=DigestUtils.md5Hex(salt+password3);*/
        /*加密网页输入的原密码*/
        String pwd1=DigestUtils.md5Hex(salt+password1);

        /*加密网页的新密码*/
        String xpassword=admin.getPassword();
        /*获取随机四位数*/
        String suiji=SaltUtils.getSalt(4);
        admin.setSalt(suiji);
        String pwdx=DigestUtils.md5Hex(suiji+xpassword);


        if(admin.getPassword().equals(password3)){
            if(ad.getPassword().equals(pwd1)){
                admin.setPassword(pwdx);
                adminService.motify(admin);
                map.put("success",true);
                map.put("msg","修改成功");
                return map;
            }else{
                map.put("success",false);
                map.put("msg","旧密码输入错误");
                return map;
            }

        }else {
            map.put("success",false);
            map.put("msg","两次密码不一致");
            return map;
        }
    }
    //退出系统
    @RequestMapping("/remove")
    public String removeAdmin(HttpSession session){
        session.removeAttribute("admins");
        return "redirect:/back/admin/login.jsp";
    }
}
