package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.config.springsecurity.MyUserDetail;
import top.franxx.blog.mapper.CommentMapper;
import top.franxx.blog.mapper.NewsMapper;
import top.franxx.blog.pojo.*;
import top.franxx.blog.service.CommentService;
import top.franxx.blog.utils.UserUtil;

import java.util.List;
@Service
public class CommenServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public LUDataGridResult findAllComment(Integer page, Integer limit) {
        if(page==null||limit==null){
            page = 1;
            limit = 10;
        }
        //设置分页信息
        PageHelper.startPage(page, limit);
        PageHelper.orderBy("com_news_id asc");
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
 /*       if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Comment> list = commentMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findCommentByName(String name, Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        CommentExample.Criteria criteria2 = example.createCriteria();
        CommentExample.Criteria criteria3 = example.createCriteria();
        if(StringUtils.isNumeric(name)){
            criteria.andComNewsIdEqualTo(Long.parseLong(name));
            criteria2.andComIdEqualTo(Long.parseLong(name));
        }
        criteria3.andComNameLike("%"+name+"%");
        example.or(criteria2);
        example.or(criteria3);
   /*     if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Comment> list = commentMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult deleteComment(Long id) {
        try{
            CommentExample example = new CommentExample();
            CommentExample.Criteria criteria = example.createCriteria();
            MyUserDetail userDetail = UserUtil.getUserDetail();
            if (userDetail.getUserGrade()<5){
                Comment c = commentMapper.selectByPrimaryKey(id);
                News n = newsMapper.selectByPrimaryKey(c.getComNewsId());
                if (n.getNewsAuthor().equals(userDetail.getUsername())){
                    criteria.andComIdEqualTo(id);
                    int count = commentMapper.deleteByExample(example);
                    return BlogResult.ok();
                }else{
                    return BlogResult.build(400,"评论删除失败！评论不存在或用户权限不足");
                }
            }
            criteria.andComIdEqualTo(id);
            int count = commentMapper.deleteByExample(example);
            if (count>0)
                return BlogResult.ok();
            else
                return BlogResult.build(400,"评论删除失败！评论不存在或用户权限不足");
        }catch (Exception e){
            return  BlogResult.build(400,"删除评论失败！");
        }
    }

    @Override
    public BlogResult batchDeleteComment(Long[] ids) {
        try{
            boolean allok = true;
            for (int i = 0;i<ids.length;i++){
                long id =ids[i];
                MyUserDetail userDetail = UserUtil.getUserDetail();
                if (userDetail.getUserGrade()<5){
                    Comment c = commentMapper.selectByPrimaryKey(id);
                    News n = newsMapper.selectByPrimaryKey(c.getComNewsId());
                    if (n.getNewsAuthor().equals(userDetail.getUsername())){
                        int count = commentMapper.deleteByPrimaryKey(id);
                    }else{
                       allok=false;
                    }
                }
                int count = commentMapper.deleteByPrimaryKey(id);

            }
            if (allok)
                return BlogResult.ok();
            else
                return BlogResult.build(400,"部分评论删除失败！评论不存在或用户权限不足");
        }catch (Exception e){
            e.printStackTrace();
            return  BlogResult.build(400,"删除文章失败！");
        }
    }
}
