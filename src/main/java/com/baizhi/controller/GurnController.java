package com.baizhi.controller;

import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/gurn")
public class GurnController {
    @Resource
    private GurnService gurnService;
    //查询上师
    @RequestMapping("findAll")
    public @ResponseBody List<Gurn> findAll(HttpSession session){
      List<Gurn> gurns= gurnService.findAll();
      return gurns;
    }
    /*分页查询上师*/
    @RequestMapping("/findAllPage")
    public @ResponseBody Map<String,Object> findAllPage(Integer page,Integer rows){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
          List<Gurn> gurns=gurnService.findAllPage(page,rows);
          Long longPage=gurnService.findPage();
          map.put("total",longPage);
          map.put("rows",gurns);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
    /*增加上师*/
    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> addGurn(MultipartFile img, HttpServletRequest request, Gurn gurn){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            String realPath=request.getRealPath("/back/admin/image/");
            //获取原始文件名
            String wname=img.getOriginalFilename();

            String uuid= UUID.randomUUID().toString().replace("-","");
            String fileName=uuid+wname;

            img.transferTo(new File(realPath,fileName));

            gurn.setHeadPic(fileName);
            gurnService.add(gurn);
            map.put("success",true);
            map.put("msg","增加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","增加失败");
        }
        return map;
    }
    /*删除上师*/
    @RequestMapping("/removeById")
    public @ResponseBody Map<String,Object> removeByIdGurn(String id,HttpServletRequest request,String img){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            String realPath=request.getRealPath("/back/admin/image/");
            String url=realPath+"/"+img;
            File file = new File(url);
            //在项目中把图片删除
            file.delete();

            gurnService.remove(id);
            map.put("success",true);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除失败");
        }
        return map;
    }
    /*批量删除上师*/
    @RequestMapping("/removeAll")
    public @ResponseBody Map<String,Object> removeAllGurn(String[] id,HttpServletRequest request,String[] img){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            for(String im:img){
                String realPath=request.getRealPath("/back/admin/image/");
                String url=realPath+"/"+im;
                File file = new File(url);
                //在项目中把图片删除
                file.delete();
            }
            gurnService.removeAll(id);
            map.put("success",true);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除失败");
        }
        return map;
    }
    /*修改上师状态*/
    @RequestMapping("/motify")
    public @ResponseBody void motifyStartGurn(String id,String start){
      Gurn gurn=gurnService.findById(id);
        if(start.equals("y")){
            gurn.setState("n");
            gurnService.motify(gurn);
        }else{
            gurn.setState("y");
            gurnService.motify(gurn);
        }
    }
}
