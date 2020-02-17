package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.News;
import top.franxx.blog.service.NewsService;

@RestController()
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 显示所有文章
     * @param newsname
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看文章")
    @RequestMapping("/list")
    public LUDataGridResult listNews(String newsname ,Integer page,Integer limit){
        if (newsname==null||newsname.equals(""))
            return newsService.findAllNews(page,limit);
        else
            //return new LUDataGridResult();
            return newsService.findNewsByName(newsname,page,limit);
    }
    /**
     * 添加文章
     * @param news
     * @return
     */
    @RequestMapping("/add")
    @Operation("添加文章")
    public BlogResult addNews(News news){
        //System.out.println(news);
        return newsService.addNews(news);
    }

    /**
     * 更新文章
     * @param news
     * @return
     */
    @RequestMapping("/update")
    @Operation("更新文章")
    public BlogResult updateNews(News news){
        return newsService.updateNews(news);
    }

    /**
     * 根据id删除文章
     * @param newsId
     * @return
     */
    @RequestMapping("/delete")
    @Operation("删除文章")
    public BlogResult deleteNews(Long newsId){
        return newsService.deleteNews(newsId);
    }
    /**
     * 根据id批量删除文章
     * @param nids 用于通过jquery的ajax请求发送过来数组参数格式为 nids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @RequestMapping("/batch_delete")
    @Operation("批量删除文章")
    public BlogResult deleteNews(@RequestParam(value = "nids[]") Long [] nids){
        return newsService.batchDeleteNews(nids);
    }
    @RequestMapping("/top")
    @Operation("置顶文章")
    public BlogResult topNews(Long id,Boolean top){
        return newsService.changeNewsTop(id,top);
    }
}
