package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    /**
     * 显示所有文章
     * @param messagename
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看留言")
    @RequestMapping("/list")
    public LUDataGridResult listMessage(String messagename , Integer page, Integer limit){
        if (messagename==null||messagename.equals(""))
            return messageService.findAllMessage(page,limit);
        else
            //return new LUDataGridResult();
            return messageService.findMessageByName(messagename,page,limit);
    }
    /**
     * 根据id删除留言
     * @param msgId
     * @return
     */
    @RequestMapping("/delete")
    @Operation("删除留言")
    public BlogResult deleteComment(Long msgId){
        return messageService.deleteMessage(msgId);
    }
    /**
     * 根据id批量删除留言
     * @param mids 用于通过jquery的ajax请求发送过来数组参数格式为 nids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @RequestMapping("/batch_delete")
    @Operation("批量删除留言")
    public BlogResult deleteComment(@RequestParam(value = "mids[]") Long [] mids){
        return messageService.batchDeleteMessage(mids);
    }
}
