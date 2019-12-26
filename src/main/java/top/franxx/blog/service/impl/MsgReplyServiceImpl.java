package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.mapper.ReplyMapper;
import top.franxx.blog.pojo.*;
import top.franxx.blog.service.MsgReplyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MsgReplyServiceImpl implements MsgReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public LUDataGridResult findAllMsgReply(Integer page, Integer limit) {
        if(page==null||limit==null){
            page = 1;
            limit = 10;
        }
        //设置分页信息
        PageHelper.startPage(page, limit);
        PageHelper.orderBy("reply_msg_id asc");
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
 /*       if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Reply> list = replyMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Reply> pageInfo = new PageInfo<Reply>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findMsgReplyByName(String name, Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        ReplyExample.Criteria criteria2 = example.createCriteria();
        ReplyExample.Criteria criteria3 = example.createCriteria();
        if(StringUtils.isNumeric(name)){
            criteria.andReplyIdEqualTo(Long.parseLong(name));
            criteria2.andReplyMsgIdEqualTo(Long.parseLong(name));
        }
        criteria3.andReplyNameLike("%"+name+"%");
        example.or(criteria2);
        example.or(criteria3);
   /*     if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Reply> list = replyMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Reply> pageInfo = new PageInfo<Reply>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult deleteMsgReply(Long id) {
        try{
            replyMapper.deleteByPrimaryKey(id);
            return BlogResult.ok();
        }catch (Exception e){
            return  BlogResult.build(400,"删除失败！");
        }
    }

    @Override
    public BlogResult batchDeleteMsgReply(Long[] ids) {
        try{
            ArrayList<Long> idList = new ArrayList<Long>();
            idList.addAll(Arrays.asList(ids));//将数组转为容器
            ReplyExample example = new ReplyExample();
            ReplyExample.Criteria criteria = example.createCriteria();
            criteria.andReplyIdIn(idList);
            replyMapper.deleteByExample(example);
            return  BlogResult.ok();
        }catch (Exception e){
            return BlogResult.build(400,"删除失败");
        }

    }
}
