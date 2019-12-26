package top.franxx.blog.service;

import top.franxx.blog.pojo.SystemParameter;

public interface SysParamService {
    /**
     * 从数据库中取去系统参数
     * @return
     */
    SystemParameter getSysParam();
}
