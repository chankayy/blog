package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.service.CommentService;

@RestController
@RequestMapping("/com")
public class CommentController {
    @Autowired
    private CommentService commentService;
    /**
     * 显示所有评论
     * @param commentname
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看评论")
    @RequestMapping("/list")
    public LUDataGridResult listComment(String commentname , Integer page, Integer limit){
        if (commentname==null||commentname.equals(""))
            return commentService.findAllComment(page,limit);
        else
            //return new LUDataGridResult();
            return commentService.findCommentByName(commentname,page,limit);
    }
    /**
     * 根据id删除评论
     * @param comId
     * @return
     */
    @RequestMapping("/delete")
    @Operation("删除评论")
    public BlogResult deleteComment(Long comId){
        return commentService.deleteComment(comId);
    }
    /**
     * 根据id批量删除评论
     * @param cids 用于通过jquery的ajax请求发送过来数组参数格式为 nids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @RequestMapping("/batch_delete")
    @Operation("批量删除评论")
    public BlogResult deleteComment(@RequestParam(value = "cids[]") Long [] cids){
        return commentService.batchDeleteComment(cids);
    }
}
