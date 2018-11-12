package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    //用户修改
    @RequestMapping("/motify")
    public @ResponseBody Map<String,Object> motifyUser(User user){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            userService.motify(user);
            map.put("success",true);
            map.put("msg","修改成功");
            return map;
        }catch (Exception e){
            map.put("success",false);
            map.put("msg","修改失败");
            return map;
        }
    }
    /*增加用户*/
    @RequestMapping("/add")
    public @ResponseBody void addUser(User user){
        userService.add(user);
    }
    /*用户登陆*/
    @RequestMapping("/login")
    public @ResponseBody String  loginUser(User user){
        String users=userService.login(user);
        if(users!=null){
            return "200";
        }
        return "用户名密码错误";
    }

    /*查询用户*/
    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page,Integer rows){
       Map<String,Object> map=new HashMap<String,Object>();
       try{
           List<User> users=userService.findAllPage(page,rows);
           Long longName=userService.findPage();
           map.put("total",longName);
           map.put("rows",users);
       }catch (Exception e){
           e.printStackTrace();
       }
        return map;
    }
    /*修改用户状态*/
    @RequestMapping("/motifyStart")
    public @ResponseBody void motifyStart(String id,String state){
        User user= userService.findById(id);
        System.out.println(user);
        System.out.println(state);
        if(state.equals("y")){
            user.setState("n");
            userService.motify(user);
        }else{
            user.setState("y");
            userService.motify(user);
        }
    }
}
