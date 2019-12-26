package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.service.LogService;

@RestController()
@RequestMapping("/log")
public class LoggingController {
    @Autowired
    private LogService logService;
    @RequestMapping("/list")
    public LUDataGridResult listLogs(Integer page,Integer limit){
        return logService.findAllLogs(page,limit);
    }

}
