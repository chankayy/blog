package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.mapper.MessageMapper;
import top.franxx.blog.pojo.*;
import top.franxx.blog.service.MessageService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public LUDataGridResult findAllMessage(Integer page, Integer limit) {
        if(page==null||limit==null){
            page = 1;
            limit = 10;
        }
        //设置分页信息
        PageHelper.startPage(page, limit);
        PageHelper.orderBy("msg_id asc");
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
 /*       if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Message> list = messageMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Message> pageInfo = new PageInfo<Message>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findMessageByName(String name, Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        MessageExample.Criteria criteria2 = example.createCriteria();
        if(StringUtils.isNumeric(name)){
            criteria.andMsgIdEqualTo(Long.parseLong(name));
        }
        criteria2.andMsgNameLike("%"+name+"%");
        example.or(criteria2);
   /*     if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Message> list = messageMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Message> pageInfo = new PageInfo<Message>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult deleteMessage(Long id) {
        try{
            messageMapper.deleteByPrimaryKey(id);
            return BlogResult.ok();
        }catch (Exception e){
            return  BlogResult.build(400,"删除失败！");
        }
    }

    @Override
    public BlogResult batchDeleteMessage(Long[] ids) {
        try{
            ArrayList<Long> idList = new ArrayList<Long>();
            idList.addAll(Arrays.asList(ids));//将数组转为容器
            MessageExample example = new MessageExample();
            MessageExample.Criteria criteria = example.createCriteria();
            criteria.andMsgIdIn(idList);
            messageMapper.deleteByExample(example);
            return  BlogResult.ok();
        }catch (Exception e){
            return BlogResult.build(400,"删除失败");
        }
    }
}
