package com.ys.lanyu1.service;

import com.ys.lanyu1.domain.UserScore;

public interface UserScoreService {

    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据(null值也插入)
     * @param record
     * @return
     */
    int insert(UserScore record);

    /**
     * 插入数据(null值不插入)
     * @param record
     * @return
     */
    int insertSelective(UserScore record);

    /**
     * 根据id查找数据
     * @param id
     * @return
     */
    UserScore selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据(不更新为null的值)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserScore record);

    /**
     * 根据主键更新数据(更新为null的值)
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserScore record);

    /**
     * 根据用户id查找用户是否存在
     * @param user_id
     * @return
     */
    int selectByUserId(Integer user_id);

    /**
     * 添加用户积分
     * @param score
     * @param user_id
     * @return
     */
    int updateUserScore(Long score,Integer user_id);
}
