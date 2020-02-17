package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.LUImageResult;
import top.franxx.blog.pojo.PictureResult;
import top.franxx.blog.service.PictureService;

@RestController
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Operation("上传缩略图")
    @RequestMapping("/upload")
    public PictureResult upload(MultipartFile uploadFile) {
        if (uploadFile==null||uploadFile.isEmpty()){
            return new PictureResult(0,"图片为空");
        }
       // System.out.println(uploadFile);
        PictureResult result = pictureService.uploadPicture(uploadFile);
        return result;
    }
    @Operation("上传文章图片")
    @RequestMapping("/upload2")
    public LUImageResult upload2(MultipartFile file) {
        LUImageResult result = pictureService.uploadPictureByEditor(file);
        return result;
    }
}
