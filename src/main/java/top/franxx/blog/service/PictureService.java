package top.franxx.blog.service;

import org.springframework.web.multipart.MultipartFile;
import top.franxx.blog.pojo.LUImageResult;
import top.franxx.blog.pojo.PictureResult;

public interface PictureService {
    /**
     * 上传缩略图文件
     * @param uploadFile
     * @return
     */
    PictureResult uploadPicture(MultipartFile uploadFile);

    /**
     * 通过富文本编辑器上传图片文件
     * @param file
     * @return
     */
    LUImageResult uploadPictureByEditor(MultipartFile file);
}
