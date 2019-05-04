package com.ys.lanyu1.service;

import com.ys.lanyu1.domain.SysUser;

public interface SysUserService {

    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据(null值也插入)
     */
    int insert(SysUser sysUser);

    /**
     * 插入数据(null值不插入)
     * @param sysUser
     * @return
     */
    int insertSelective(SysUser sysUser);

    /**
     * 根据主键查询数据
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 更新数据(不更新null)
     * @param sysUser
     * @return
     */
    int updateByPrimaryKeySelective(SysUser sysUser);

    /**
     * 更新数据(更新null)
     * @param sysUser
     * @return
     */
    int updateByPrimaryKey(SysUser sysUser);

}



