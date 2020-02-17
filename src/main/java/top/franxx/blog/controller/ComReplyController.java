package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.service.ComReplyService;

@RestController
@RequestMapping("/comreply")
public class ComReplyController {
    @Autowired
    private ComReplyService comReplyService;
    /**
     * 显示所有评论回复
     * @param comreplyname
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看评论回复")
    @RequestMapping("/list")
    public LUDataGridResult listComment(String comreplyname , Integer page, Integer limit){
        if (comreplyname==null||comreplyname.equals(""))
            return comReplyService.findAllComReply(page,limit);
        else
            //return new LUDataGridResult();
            return comReplyService.findComReplyByName(comreplyname,page,limit);
    }
    /**
     * 根据id删除评论回复
     * @param comreplyId
     * @return
     */
    @RequestMapping("/delete")
    @Operation("删除评论回复")
    public BlogResult deleteComment(Long comreplyId){
        System.out.println(comreplyId+" sssss");
        return comReplyService.deleteComReply(comreplyId);
    }
    /**
     * 根据id批量删除评论回复
     * @param crids 用于通过jquery的ajax请求发送过来数组参数格式为 nids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @RequestMapping("/batch_delete")
    @Operation("批量删除评论回复")
    public BlogResult deleteComment(@RequestParam(value = "crids[]") Long [] crids){
        return comReplyService.batchDeleteComReply(crids);
    }
}
