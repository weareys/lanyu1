package com.ys.lanyu1.service;

import com.ys.lanyu1.domain.ScoreFlow;

public interface ScoreFlowService {

    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据(null值也插入)
     * @param scoreFlow
     * @return
     */
    int insert(ScoreFlow scoreFlow);

    /**
     * 插入数据(null值不可以插入)
     * @param scoreFlow
     * @return
     */
    int insertSelective(ScoreFlow scoreFlow);

    /**
     * 根据id查找数据
     * @param id
     * @return
     */
    ScoreFlow selectByPrimaryKey(Integer id);

    /**
     * 根据id更新数据(更新null)
     * @param scoreFlow
     * @return
     */
    int updateByPrimaryKeySelective(ScoreFlow scoreFlow);

    /**
     * 根据主键更新数据(不更新null)
     * @param scoreFlow
     * @return
     */
    int updateByPrimaryKey(ScoreFlow scoreFlow);



}
