package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.Gurn;
import com.baizhi.service.ArticleService;
import com.baizhi.service.GurnService;
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
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private GurnService gurnService;
    //展示文章
    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAllArticle(Integer page,Integer rows,String classift){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
           List<Article> articles=articleService.findAllPageArticle(page,rows,classift);
            Long longPage=articleService.findPageArticle(classift);
            map.put("total",longPage);
            map.put("rows",articles);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /*插入文章*/
    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> addArticle(String gurn_id,MultipartFile img, HttpServletRequest request,Article article) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
           String realPath=request.getRealPath("/back/admin/image/");
           String wname=img.getOriginalFilename();

            String uuid= UUID.randomUUID().toString().replace("-","");
            String fileName=uuid+wname;

            img.transferTo(new File(realPath,fileName));
            /*根据id查询上师*/
           Gurn gurn=gurnService.findById(gurn_id);
            article.setGurn(gurn);

            article.setImgPath(fileName);
            articleService.add(article);
            map.put("success", true);
            map.put("msg", "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "增加失败");
        }
        return map;
    }
    /*根据id删除*/
    @RequestMapping("/remove")
    public @ResponseBody Map<String,Object> removeArticle(String id,HttpServletRequest request,String img){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            String realPath=request.getRealPath("/back/admin/image/");
            String url=realPath+"/"+img;
            File file = new File(url);
            //在项目中把图片删除
            file.delete();

            articleService.remove(id);
            map.put("success",true);
            map.put("msg","删除成功");
        }catch (Exception e){
            map.put("success",false);
            map.put("msg","删除失败");
        }
        return map;
    }
    /*修改文章的状态*/
    @RequestMapping("/motify")
    public @ResponseBody void motifyArticle(String  status,String id){
        Article articles=articleService.findById(id);
        if(status.equals("y")){
            articles.setStatus("n");
            articleService.motify(articles);
        }else{
            articles.setStatus("y");
            articleService.motify(articles);
        }
    }
    /*批量删除文章*/
    @RequestMapping("/removeAll")
    public @ResponseBody Map<String,Object> removeAll(String[] id,HttpServletRequest request,String[] img){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            for(String im:img){
                //文件通过相对路径获取绝对路径
                String realPath=request.getRealPath("/back/admin/image/");
                String url=realPath+"/"+im;
                File file = new File(url);
                //在项目中把图片删除
                file.delete();
            }
            articleService.removeAll(id);
            map.put("success",true);
            map.put("msg","增加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","增加失败");
        }
        return map;
    }
}
