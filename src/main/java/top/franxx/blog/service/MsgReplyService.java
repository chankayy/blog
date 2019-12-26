package top.franxx.blog.service;

import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;

public interface MsgReplyService {
    /**
     * 分页查找所有文章
     * @param page
     * @param limit
     * @return
     */
    LUDataGridResult findAllMsgReply(Integer page, Integer limit);

    /**
     * 通过标题分页查找文章
     * @param name
     * @return
     */
    LUDataGridResult findMsgReplyByName(String name,Integer page, Integer limit);

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    BlogResult deleteMsgReply(Long id);

    /**
     *根据id批量删除文章
     * @param ids
     * @return
     */
    BlogResult batchDeleteMsgReply(Long [] ids);
}
