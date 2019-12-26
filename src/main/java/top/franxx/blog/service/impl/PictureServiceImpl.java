package top.franxx.blog.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.franxx.blog.pojo.LUImageResult;
import top.franxx.blog.pojo.PictureResult;
import top.franxx.blog.service.PictureService;
import top.franxx.blog.utils.FtpUtil;
import top.franxx.blog.utils.IDUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
    @Value("${ftp.host}")
    private  String host;
    @Value("${ftp.port}")
    private  String port;
    @Value("${ftp.username}")
    private  String username;
    @Value("${ftp.password}")
    private  String password;
    @Value("${ftp.basePath}")
    private  String basePath;
    @Value("${ftp.imagBaseUrl}")
    private  String imageBaseUrl;
    @Override
    public PictureResult uploadPicture(MultipartFile uploadFile) {

        //判断文件是否为空
        if(uploadFile==null||uploadFile.isEmpty()) return new PictureResult(1, null, "上传失败，上传文件不能为空");

        //取文件扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新文件名
        //可以使用uuid生成新文件名。
        //UUID.randomUUID()
        //可以是时间+随机数生成文件名
        String imageName = IDUtils.genImageName();
        //把图片上传到ftp服务器（图片服务器）
        //需要把ftp的参数配置到配置文件中
        //文件在服务器的存放路径，应该使用日期分隔的目录结构
        DateTime dateTime = new DateTime();
        String filePath = dateTime.toString("/yyyy/MM/dd");
        try {
            boolean isOK = FtpUtil.uploadFile(host, Integer.parseInt(port), username, password, basePath, filePath, imageName+ext, uploadFile.getInputStream());
            //System.out.println(host+"-"+port+"-"+username+"-"+password+"-"+basePath+"-"+filePath+"-"+imageName+"-"+ext+"-");
            if(isOK) {
                return new PictureResult(0, imageBaseUrl+filePath+"/"+imageName+ext);
            }
            System.out.println(isOK);

        } catch (NumberFormatException e) {
            System.err.println("配置格式有误");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new PictureResult(1, null, "上传失败，FTP异常");

    }

    @Override
    public LUImageResult uploadPictureByEditor(MultipartFile uploadFile) {
        //判断文件是否为空
        if(uploadFile==null||uploadFile.isEmpty()) return new LUImageResult(1, "上传失败,上传文件不能为空", null);

        //取文件扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新文件名
        //可以使用uuid生成新文件名。
        //UUID.randomUUID()
        //可以是时间+随机数生成文件名
        String imageName = IDUtils.genImageName();
        //把图片上传到ftp服务器（图片服务器）
        //需要把ftp的参数配置到配置文件中
        //文件在服务器的存放路径，应该使用日期分隔的目录结构
        DateTime dateTime = new DateTime();
        String filePath = dateTime.toString("/yyyy/MM/dd");
        try {
            boolean isOK = FtpUtil.uploadFile(host, Integer.parseInt(port), username, password, basePath, filePath, imageName+ext, uploadFile.getInputStream());
            //System.out.println(host+"-"+port+"-"+username+"-"+password+"-"+basePath+"-"+filePath+"-"+imageName+"-"+ext+"-");
            if(isOK) {
                Map<String,String>data = new HashMap<>();
                data.put("src",imageBaseUrl+filePath+"/"+imageName+ext);
                data.put("title",imageName+ext);
                return new LUImageResult(0,"上传成功", data);
            }
            System.out.println(isOK);

        } catch (NumberFormatException e) {
            System.err.println("配置格式有误");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new LUImageResult(1, "上传失败，FTP错误", null);
    }
}
