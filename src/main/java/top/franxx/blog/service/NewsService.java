package top.franxx.blog.service;

import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.News;

public interface NewsService {
    /**
     * 分页查找所有文章
     * @param page
     * @param limit
     * @return
     */
    LUDataGridResult findAllNews(Integer page, Integer limit);

    /**
     * 通过标题分页查找文章
     * @param name
     * @return
     */
    LUDataGridResult findNewsByName(String name,Integer page, Integer limit);

    /**
     * 添加文章
     * @param news
     * @return
     */
    BlogResult addNews(News news);

    /**
     * 修改文章
     * @param news
     * @return
     */
    BlogResult updateNews(News news);

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    BlogResult deleteNews(Long id);

    /**
     *根据id批量删除文章
     * @param ids
     * @return
     */
    BlogResult batchDeleteNews(Long [] ids);

    /**
     * 设置是否置顶
     * @param top
     * @return
     */
    BlogResult changeNewsTop(Long id,Boolean top);
}
