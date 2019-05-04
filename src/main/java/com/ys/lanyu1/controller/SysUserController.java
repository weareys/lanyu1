package com.ys.lanyu1.controller;

import com.ys.lanyu1.domain.SysUser;
import com.ys.lanyu1.service.SysUserService;
import com.ys.lanyu1.support.SimpleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @PostMapping("/add")
    public SimpleResult add(@RequestBody  SysUser sysUser){
        sysUserService.insertSelective(sysUser);
        return  SimpleResult.buildSuccess("添加用户成功");
    }

}
