package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.config.springsecurity.MyUserDetail;
import top.franxx.blog.mapper.ComReplyMapper;
import top.franxx.blog.mapper.CommentMapper;
import top.franxx.blog.mapper.NewsMapper;
import top.franxx.blog.pojo.*;
import top.franxx.blog.service.ComReplyService;
import top.franxx.blog.utils.UserUtil;

import java.util.List;
@Service
public class ComReplyServiceImpl implements ComReplyService {
    @Autowired
    private ComReplyMapper comReplyMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public LUDataGridResult findAllComReply(Integer page, Integer limit) {
        if(page==null||limit==null){
            page = 1;
            limit = 10;
        }
        //设置分页信息
        PageHelper.startPage(page, limit);
        PageHelper.orderBy("reply_com_id asc");
        ComReplyExample example = new ComReplyExample();
        ComReplyExample.Criteria criteria = example.createCriteria();
 /*       if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<ComReply> list = comReplyMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<ComReply> pageInfo = new PageInfo<ComReply>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findComReplyByName(String name, Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        ComReplyExample example = new ComReplyExample();
        ComReplyExample.Criteria criteria = example.createCriteria();
        ComReplyExample.Criteria criteria2 = example.createCriteria();
        ComReplyExample.Criteria criteria3 = example.createCriteria();
        if(StringUtils.isNumeric(name)){
            criteria.andReplyIdEqualTo(Long.parseLong(name));
            criteria2.andReplyComIdEqualTo(Long.parseLong(name));
        }
        criteria3.andReplyNameLike("%"+name+"%");
        example.or(criteria2);
        example.or(criteria3);
   /*     if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<ComReply> list = comReplyMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<ComReply> pageInfo = new PageInfo<ComReply>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult deleteComReply(Long id) {
        try{
            ComReplyExample example = new ComReplyExample();
            ComReplyExample.Criteria criteria = example.createCriteria();
            MyUserDetail userDetail = UserUtil.getUserDetail();
            if (userDetail.getUserGrade()<5){
                ComReply r = comReplyMapper.selectByPrimaryKey(id);
                Comment c = commentMapper.selectByPrimaryKey(r.getReplyComId());
                News n = newsMapper.selectByPrimaryKey(c.getComNewsId());
                if (n.getNewsAuthor().equals(userDetail.getUsername())){
                    criteria.andReplyIdEqualTo(id);
                    int count = comReplyMapper.deleteByExample(example);
                    return BlogResult.ok();
                }else{
                    return BlogResult.build(400,"回复删除失败！回复不存在或用户权限不足");
                }
            }
            criteria.andReplyIdEqualTo(id);
            int count = comReplyMapper.deleteByExample(example);
            if (count>0)
                return BlogResult.ok();
            else
                return BlogResult.build(400,"回复删除失败！回复不存在或用户权限不足");
        }catch (Exception e){
            return  BlogResult.build(400,"删除回复失败！");
        }
    }

    @Override
    public BlogResult batchDeleteComReply(Long[] ids) {
        try{
            boolean allok = true;
            for (int i = 0;i<ids.length;i++){
                long id =ids[i];
                ComReplyExample example = new ComReplyExample();
                ComReplyExample.Criteria criteria = example.createCriteria();
                MyUserDetail userDetail = UserUtil.getUserDetail();
                if (userDetail.getUserGrade()<5){
                    ComReply r = comReplyMapper.selectByPrimaryKey(id);
                    Comment c = commentMapper.selectByPrimaryKey(r.getReplyComId());
                    News n = newsMapper.selectByPrimaryKey(c.getComNewsId());
                    if (n.getNewsAuthor().equals(userDetail.getUsername())){
                        criteria.andReplyIdEqualTo(id);
                        int count = comReplyMapper.deleteByExample(example);
                    }else{
                        allok=false;
                        continue;
                    }
                }
                criteria.andReplyIdEqualTo(id);
                int count = comReplyMapper.deleteByExample(example);
            }
            if (allok)
                return BlogResult.ok();
            else
                return BlogResult.build(400,"部分回复删除失败！回复不存在或用户权限不足");
        }catch (Exception e){
            e.printStackTrace();
            return  BlogResult.build(400,"删除回复失败！");
        }
    }
}
