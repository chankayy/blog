package top.franxx.blog.service;

import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;

public interface MessageService {
    /**
     * 分页查找所有文章
     * @param page
     * @param limit
     * @return
     */
    LUDataGridResult findAllMessage(Integer page, Integer limit);

    /**
     * 通过标题分页查找文章
     * @param name
     * @return
     */
    LUDataGridResult findMessageByName(String name,Integer page, Integer limit);

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    BlogResult deleteMessage(Long id);

    /**
     *根据id批量删除文章
     * @param ids
     * @return
     */
    BlogResult batchDeleteMessage(Long [] ids);
}
