package top.franxx.blog.service;

import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.Share;

public interface ShareService {
    /**
     * 分页查找所有文章
     * @param page
     * @param limit
     * @return
     */
    LUDataGridResult findAllShare(Integer page, Integer limit);

    /**
     * 通过标题分页查找文章
     * @param name
     * @return
     */
    LUDataGridResult findShareByName(String name,Integer page, Integer limit);

    /**
     * 添加文章
     * @param share
     * @return
     */
    BlogResult addShare(Share share);

    /**
     * 修改文章
     * @param share
     * @return
     */
    BlogResult updateShare(Share share);

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    BlogResult deleteShare(Long id);

    /**
     *根据id批量删除文章
     * @param ids
     * @return
     */
    BlogResult batchDeleteShare(Long [] ids);
}
