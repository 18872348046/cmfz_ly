package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;
    @Resource
    private AlbumService albumService;

    @RequestMapping("/add")
    public @ResponseBody
    Map<String, Object> addChapter(MultipartFile audio, HttpServletRequest request, Chapter chapter, String album_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //文件通过相对路径获取绝对路径
            String realPath = request.getRealPath("/back/admin/audio/");
            //获取原始文件名
            String wname = audio.getOriginalFilename();
            String uuid= UUID.randomUUID().toString().replace("-","");
            String fileName=uuid+wname;
            audio.transferTo(new File(realPath, fileName));
            chapter.setPath(fileName);
            //计算时长和大小要的路径
            String realPath2 = realPath + "/" + fileName;
            //计算时长
            String s = FileUtil.audioLength(realPath2, request);
            System.out.println(s);
            chapter.setDuration(s);
            //计算大小
            Double aDouble = FileUtil.audioSize(realPath2, request);
            chapter.setSize(aDouble);
            /*根据专辑的id查询专辑*/
            Album album = albumService.findById(album_id);
            chapter.setAlbum(album);
            chapterService.add(chapter);
            map.put("success", true);
            map.put("msg", "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "增加失败");
        }
        return map;
    }

    /*文件下载*/
    @RequestMapping("/download1")
    public @ResponseBody
    void downloadChapter(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //根据接受的文件名去服务器中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/back/admin/audio");
        //以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, path));
        //设置响应头
        //response.setContentType("audio/mpeg");
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(path, "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //使用IOUtil工具类（拷贝文件）
        IOUtils.copy(is, os);
        //关流
        IOUtils.closeQuietly(os);
        //关流
        IOUtils.closeQuietly(is);
    }
}
