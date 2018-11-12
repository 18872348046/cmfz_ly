package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;
    /*查询专辑*/
    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAllAlbum(Integer page,Integer rows){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
          List<Album> albums=albumService.findAllPage(page,rows);
          Long longPage=albumService.findPage();
            /*专辑里章节的集数*/
          for(Album al:albums){
              al.setCount(al.getChildren().size());
              albumService.motify(al);
          }
          map.put("total",longPage);
          map.put("rows",albums);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
    /*增加专辑*/
    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> addAlbum(MultipartFile img, HttpServletRequest request, Album album){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            //文件通过相对路径获取绝对路径
            String realPath=request.getRealPath("/back/admin/image/");
            //获取原始文件名
            String wname=img.getOriginalFilename();

            String uuid=UUID.randomUUID().toString().replace("-","");
            String fileName=uuid+wname;

            img.transferTo(new File(realPath,fileName));
            album.setCoverImg(fileName);
            albumService.add(album);
            map.put("success",true);
            map.put("msg","增加成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","增加失败");
        }
        return map;
    }
    /*查询单张专辑表*/
    @RequestMapping("/findAllAlbum")
    public @ResponseBody List<Album> findAll(){
      List<Album> album=albumService.findAll();
      return album;
    }
    /*根据id查询专辑*/
    @RequestMapping("/findById")
    public  @ResponseBody  Album findById(String id, HttpSession session){
        Album album=albumService.findById(id);
        session.setAttribute("imgName",album.getCoverImg());
       return album;
    }
}
