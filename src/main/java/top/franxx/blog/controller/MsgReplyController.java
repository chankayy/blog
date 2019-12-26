package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.service.MsgReplyService;

@RestController
@RequestMapping("/msgreply")
public class MsgReplyController {
    @Autowired
    private MsgReplyService msgReplyService;
    /**
     * 显示所有文章
     * @param msgreplyname
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看留言回复")
    @RequestMapping("/list")
    public LUDataGridResult listMessage(String msgreplyname , Integer page, Integer limit){
        if (msgreplyname==null||msgreplyname.equals(""))
            return msgReplyService.findAllMsgReply(page,limit);
        else
            //return new LUDataGridResult();
            return msgReplyService.findMsgReplyByName(msgreplyname,page,limit);
    }
    /**
     * 根据id删除留言回复
     * @param msgreplyId
     * @return
     */
    @RequestMapping("/delete")
    @Operation("删除留言回复")
    public BlogResult deleteComment(Long msgreplyId){
        return msgReplyService.deleteMsgReply(msgreplyId);
    }
    /**
     * 根据id批量删除留言回复
     * @param mrids 用于通过jquery的ajax请求发送过来数组参数格式为 nids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @RequestMapping("/batch_delete")
    @Operation("批量删除留言回复")
    public BlogResult deleteComment(@RequestParam(value = "mrids[]") Long [] mrids){
        return msgReplyService.batchDeleteMsgReply(mrids);
    }
}
