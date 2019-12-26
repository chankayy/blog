package top.franxx.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.franxx.blog.mapper.SystemParameterMapper;
import top.franxx.blog.pojo.SystemParameter;
import top.franxx.blog.service.SysParamService;
@Service
public class SysParamServiceImpl implements SysParamService {
    @Autowired
    private SystemParameterMapper systemParameterMapper;
    @Override
    public SystemParameter getSysParam() {
        return systemParameterMapper.selectByExample(null).get(0);
    }
}
