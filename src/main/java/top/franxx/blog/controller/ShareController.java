package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.Share;
import top.franxx.blog.service.ShareService;

@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareService shareService;
    /**
     * 显示所有文章
     * @param sharename
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看资源")
    @RequestMapping("/list")
    public LUDataGridResult listNews(String sharename , Integer page, Integer limit){
        if (sharename==null||sharename.equals(""))
            return shareService.findAllShare(page,limit);
        else
            //return new LUDataGridResult();
            return shareService.findShareByName(sharename,page,limit);
    }
    /**
     * 添加文章
     * @param share
     * @return
     */
    @RequestMapping("/add")
    @Operation("添加资源")
    public BlogResult addNews(Share share){
        //System.out.println(news);
        return shareService.addShare(share);
    }

    /**
     * 更新文章
     * @param share
     * @return
     */
    @RequestMapping("/update")
    @Operation("更新资源")
    public BlogResult updateNews(Share share){
        return shareService.updateShare(share);
    }

    /**
     * 根据id删除文章
     * @param shareId
     * @return
     */
    @RequestMapping("/delete")
    @Operation("删除资源")
    public BlogResult deleteNews(Long shareId){
        return shareService.deleteShare(shareId);
    }
    /**
     * 根据id批量删除文章
     * @param sids 用于通过jquery的ajax请求发送过来数组参数格式为 nids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @RequestMapping("/batch_delete")
    @Operation("批量删除资源")
    public BlogResult deleteNews(@RequestParam(value = "sids[]") Long [] sids){
        return shareService.batchDeleteShare(sids);
    }
}
