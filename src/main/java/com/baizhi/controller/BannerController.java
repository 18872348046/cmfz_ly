package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;
    //展示轮播图
    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAllBanner(Integer page,Integer rows){
        Map map=new HashMap<String,Object>();
        List<Banner> banners=bannerService.findAllPage(page,rows);
        Long sun=bannerService.findPage();
        map.put("total",sun);
        map.put("rows",banners);
        return map;
    }
    //根据id删除轮播图片
    @RequestMapping("removeById")
    public @ResponseBody Map<String,Object> removeById(String id,HttpServletRequest request,String img){
        Map map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            String realPath=request.getRealPath("/back/admin/image/");
            String url=realPath+"/"+img;
            File file = new File(url);
            //在项目中把图片删除
            file.delete();

            bannerService.remove(id);
            map.put("success",true);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }
    //增加轮播图
    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> addBanner(MultipartFile img, HttpServletRequest request,Banner banner){
        Map map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            String realPath=request.getRealPath("/back/admin/image/");
            //获取原始文件名
            String wname=img.getOriginalFilename();
            String uuid= UUID.randomUUID().toString().replace("-","");
            String fileName=uuid+wname;


            img.transferTo(new File(realPath,fileName));
            banner.setImgPoth(fileName);
            bannerService.add(banner);
            map.put("success",true);
            map.put("msg","增加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","增加失败");
        }
        return map;
    }
    //根据id查询轮播图
    @RequestMapping("/findById")
    public @ResponseBody Banner findById(String id){
        Banner banners=bannerService.findById(id);
        System.out.println(banners);
        return banners;
    }
    //修改轮播图
    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> updateBanner(MultipartFile img, HttpServletRequest request,Banner banner){
        System.out.println(banner);
        System.out.println(img);
        Map map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            String realPath=request.getRealPath("/back/admin/image/");
            //获取原始文件名
            String fileName=img.getOriginalFilename();
            //如果改了图片则从新上传，反之用原始图片
            if(fileName!=""){
                img.transferTo(new File(realPath,fileName));
                banner.setImgPoth(fileName);
            }else {}
            bannerService.motify(banner);

            map.put("success",true);
            map.put("msg","修改成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","修改失败");
        }
        return map;
    }
    //批量删除
    @RequestMapping("/removeAll")
    public @ResponseBody Map<String,Object> removeAllBanner(String[] id,HttpServletRequest request,String[] img){
        Map map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            for(String im:img){
                String realPath=request.getRealPath("/back/admin/image/");
                String url=realPath+"/"+im;
                File file = new File(url);
                //在项目中把图片删除
                file.delete();
            }

            bannerService.removeAll(id);
            map.put("success",true);
            map.put("msg","修改成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","修改失败");
        }
        return map;
    }
}
