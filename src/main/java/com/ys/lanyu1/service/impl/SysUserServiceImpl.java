package com.ys.lanyu1.service.impl;

import com.ys.lanyu1.domain.SysUser;
import com.ys.lanyu1.mapper.SysUserMapper;
import com.ys.lanyu1.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public int insertSelective(SysUser sysUser) {
        return sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public int updateByPrimaryKey(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
