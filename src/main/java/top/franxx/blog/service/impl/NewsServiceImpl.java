package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.config.springsecurity.MyUserDetail;
import top.franxx.blog.mapper.NewsMapper;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.News;
import top.franxx.blog.pojo.NewsExample;
import top.franxx.blog.service.NewsService;
import top.franxx.blog.utils.UserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService
{
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public LUDataGridResult findAllNews(Integer page, Integer limit) {
        if(page==null||limit==null){
            page = 1;
            limit = 10;
        }
        //设置分页信息
        PageHelper.startPage(page, limit);
        PageHelper.orderBy("news_id desc");
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
 /*       if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<News> list = newsMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<News> pageInfo = new PageInfo<News>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findNewsByName(String name, Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        NewsExample.Criteria criteria2 = example.createCriteria();
        NewsExample.Criteria criteria3 = example.createCriteria();
        criteria.andNewsNameLike("%"+name+"%");
        criteria2.andNewsAbstractLike("%"+name+"%");
        if(StringUtils.isNumeric(name)){
            criteria3.andNewsIdEqualTo(Long.parseLong(name));
        }
        example.or(criteria2);
        example.or(criteria3);
        MyUserDetail userDetail = UserUtil.getUserDetail();
   /*     if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<News> list = newsMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<News> pageInfo = new PageInfo<News>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult addNews(News news) {
        news.setNewsTime(new Date());
        MyUserDetail userDetail = UserUtil.getUserDetail();
        news.setNewsAuthor(userDetail.getUsername());
        news.setNewsView(0L);
        if (news.getNewsImg()==null||news.getNewsImg().equals(""))
            news.setNewsImg("http://image.franxx.top/images/null.jpg");
        newsMapper.insert(news);
        return  BlogResult.ok();
    }

    @Override
    public BlogResult updateNews(News news) {
        NewsExample example2 = new NewsExample();
        NewsExample.Criteria criteria2 = example2.createCriteria();
        MyUserDetail userDetail = UserUtil.getUserDetail();
        if (userDetail.getUserGrade()<5){
            criteria2.andNewsAuthorEqualTo(userDetail.getUsername());
        }
        criteria2.andNewsIdEqualTo(news.getNewsId());
        List<News> newsList = newsMapper.selectByExampleWithBLOBs(example2);
        if (newsList==null||newsList.isEmpty()){
            return BlogResult.build(400,"修改失败，文章不存在或权限不足！");
        }
        News n = newsList.get(0);
        news.setNewsTime(new Date());
        news.setNewsAuthor(n.getNewsAuthor());
        news.setNewsView(n.getNewsView());
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsIdEqualTo(news.getNewsId());
        newsMapper.updateByExampleWithBLOBs(news,example);
        return BlogResult.ok();
    }

    @Override
    public BlogResult deleteNews(Long id) {
        try{
            NewsExample example = new NewsExample();
            NewsExample.Criteria criteria = example.createCriteria();
            MyUserDetail userDetail = UserUtil.getUserDetail();
            if (userDetail.getUserGrade()<5){
                criteria.andNewsAuthorEqualTo(userDetail.getUsername());
            }
            criteria.andNewsIdEqualTo(id);
            int count = newsMapper.deleteByExample(example);
            if (count>0)
                return BlogResult.ok();
            else
                return BlogResult.build(400,"删除文章失败！文章不存在或用户权限不足");
        }catch (Exception e){
            return  BlogResult.build(400,"删除文章失败！");
        }
    }

    @Override
    public BlogResult batchDeleteNews(Long[] ids) {
        try{
            ArrayList<Long> idList = new ArrayList<Long>();
            idList.addAll(Arrays.asList(ids));//将数组转为容器
            NewsExample example = new NewsExample();
            NewsExample.Criteria criteria = example.createCriteria();
            criteria.andNewsIdIn(idList);
            MyUserDetail userDetail = UserUtil.getUserDetail();
            if (userDetail.getUserGrade()<5){
                criteria.andNewsAuthorEqualTo(userDetail.getUsername());
            }
            int count = newsMapper.deleteByExample(example);
            if (count==ids.length)
                return BlogResult.ok();
            else if (count>0&&count<ids.length)
                return BlogResult.build(400,"部分文章删除失败！文章不存在或用户权限不足");
            else
                return BlogResult.build(400,"文章删除失败！文章不存在或用户权限不足");
        }catch (Exception e){
            return BlogResult.build(400,"删除文章失败");
        }
    }

    @Override
    public BlogResult changeNewsTop(Long id,Boolean top) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsIdEqualTo(id);
        MyUserDetail userDetail = UserUtil.getUserDetail();
        if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }
        List<News> list = newsMapper.selectByExampleWithBLOBs(example);
        if (list==null||list.isEmpty()){
            return BlogResult.build(400,"文章不存在或权限不足");
        }
        News news = list.get(0);
        news.setNewsTop(top?"checked":"");
        newsMapper.updateByPrimaryKeyWithBLOBs(news);
        return BlogResult.ok();
    }
}
