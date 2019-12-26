package top.franxx.blog.service;

import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.Log;

public interface LogService {
    /**
     * 添加日志
     * @param log
     */
    void addLog(Log log);

    /**
     * 从数据库中查找日志
     * @param page
     * @param limit
     * @return
     */
    LUDataGridResult findAllLogs(Integer page,Integer limit);
}
