package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.mapper.LogMapper;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.Log;
import top.franxx.blog.pojo.News;
import top.franxx.blog.service.LogService;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    public void addLog(Log log){
        if (log!=null)
            logMapper.insert(log);
        else
            throw new RuntimeException();
    }

    @Override
    public LUDataGridResult findAllLogs(Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        List<Log> list = logMapper.selectByExample(null);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<Log> pageInfo = new PageInfo<Log>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }
}
