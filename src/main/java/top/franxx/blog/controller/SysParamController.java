package top.franxx.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.SystemParameter;
import top.franxx.blog.service.SysParamService;

@RestController
@RequestMapping("/system")
public class SysParamController {
    @Autowired
    private SysParamService sysParamService;
    @RequestMapping("/param")
    @Operation("查看系统参数")
    public SystemParameter getsysParam(){
        return sysParamService.getSysParam();
    }
}
