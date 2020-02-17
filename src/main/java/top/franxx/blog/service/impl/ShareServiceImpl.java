package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.config.springsecurity.MyUserDetail;
import top.franxx.blog.mapper.ShareMapper;
import top.franxx.blog.pojo.*;
import top.franxx.blog.service.ShareService;
import top.franxx.blog.utils.UserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;
    @Override
    public LUDataGridResult findAllShare(Integer page, Integer limit) {
                if(page==null||limit==null){
            page = 1;
            limit = 10;
        }
        //设置分页信息
        PageHelper.startPage(page, limit);
        PageHelper.orderBy("share_id asc");
        ShareExample example = new ShareExample();
        ShareExample.Criteria criteria = example.createCriteria();
 /*       if (userDetail.getUserGrade()<5){
            criteria.andNewsAuthorEqualTo(userDetail.getUsername());
        }*/
        List<Share> list = shareMapper.selectByExample(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Share> pageInfo = new PageInfo<Share>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findShareByName(String name, Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        ShareExample example = new ShareExample();
        ShareExample.Criteria criteria = example.createCriteria();
        ShareExample.Criteria criteria2 = example.createCriteria();
        ShareExample.Criteria criteria3 = example.createCriteria();
        ShareExample.Criteria criteria4 = example.createCriteria();
        criteria.andShareNameEqualTo("%"+name+"%");
        criteria2.andShareIntroEqualTo("%"+name+"%");
        criteria4.andShareAuthorEqualTo("%"+name+"%");
        if(StringUtils.isNumeric(name)){
            criteria3.andShareIdEqualTo(Long.parseLong(name));
        }
        example.or(criteria2);
        example.or(criteria3);
        example.or(criteria4);
        List<Share> list = shareMapper.selectByExample(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Share> pageInfo = new PageInfo<Share>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult addShare(Share share) {
        share.setShareTime(new Date());
        MyUserDetail userDetail = UserUtil.getUserDetail();
        share.setShareAuthor(userDetail.getUsername());
        share.setShareStatus(0+"");
        if (share.getShareImg()==null||share.getShareImg().equals(""))
            share.setShareImg("http://image.franxx.top/images/null.jpg");
        shareMapper.insert(share);
        return  BlogResult.ok();
    }

    @Override
    public BlogResult updateShare(Share share) {
        ShareExample example2 = new ShareExample();
        ShareExample.Criteria criteria2 = example2.createCriteria();
        MyUserDetail userDetail = UserUtil.getUserDetail();
        if (userDetail.getUserGrade()<5){
            criteria2.andShareAuthorEqualTo(userDetail.getUsername());
        }
        criteria2.andShareIdEqualTo(share.getShareId());
        List<Share> shareList = shareMapper.selectByExample(example2);
        if (shareList==null||shareList.isEmpty()){
            return BlogResult.build(400,"修改失败，资源不存在或权限不足！");
        }
        Share s = shareList.get(0);
        share.setShareTime(s.getShareTime());
        share.setShareId(s.getShareId());
        share.setShareAuthor(s.getShareAuthor());
        ShareExample example = new ShareExample();
        ShareExample.Criteria criteria = example.createCriteria();
        criteria.andShareIdEqualTo(share.getShareId());
        shareMapper.updateByExample(share,example);
        return BlogResult.ok();
    }

    @Override
    public BlogResult deleteShare(Long id) {
        try{
            ShareExample example = new ShareExample();
            ShareExample.Criteria criteria = example.createCriteria();
            MyUserDetail userDetail = UserUtil.getUserDetail();
            if (userDetail.getUserGrade()<5){
                criteria.andShareAuthorEqualTo(userDetail.getUsername());
            }
            criteria.andShareIdEqualTo(id);
            int count = shareMapper.deleteByExample(example);
            if (count>0)
                return BlogResult.ok();
            else
                return BlogResult.build(400,"删除资源失败！文章不存在或用户权限不足");
        }catch (Exception e){
            return  BlogResult.build(400,"删除资源失败！");
        }
    }

    @Override
    public BlogResult batchDeleteShare(Long[] ids) {
        try{
            ArrayList<Long> idList = new ArrayList<Long>();
            idList.addAll(Arrays.asList(ids));//将数组转为容器
            ShareExample example = new ShareExample();
            ShareExample.Criteria criteria = example.createCriteria();
            criteria.andShareIdIn(idList);
            MyUserDetail userDetail = UserUtil.getUserDetail();
            if (userDetail.getUserGrade()<5){
                criteria.andShareAuthorEqualTo(userDetail.getUsername());
            }
            int count = shareMapper.deleteByExample(example);
            if (count==ids.length)
                return BlogResult.ok();
            else if (count>0&&count<ids.length)
                return BlogResult.build(400,"部分资源删除失败！文章不存在或用户权限不足");
            else
                return BlogResult.build(400,"删除资源失败！文章不存在或用户权限不足");
        }catch (Exception e){
            return BlogResult.build(400,"删除资源失败");
        }
    }
}
