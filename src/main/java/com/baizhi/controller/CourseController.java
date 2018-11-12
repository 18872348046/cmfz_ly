package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;
    /*展示必修功课*/
    @RequestMapping("/findAll")
    public @ResponseBody List<Course> findAll(){
        List<Course> courses=courseService.findAll();
        return courses;
    }
    /*增加必修功课*/
    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> addCourse(Course course){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            courseService.add(course);
            map.put("success",true);
            map.put("msg","增加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("Success",false);
            map.put("msg","增加失败");
        }
        return map;
    }
    /*根据id删除必修功课*/
    @RequestMapping("/remove")
    public @ResponseBody void removeCourse(String id){
            courseService.remove(id);
    }
}
