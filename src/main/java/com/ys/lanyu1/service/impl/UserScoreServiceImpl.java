package com.ys.lanyu1.service.impl;

import com.ys.lanyu1.domain.UserScore;
import com.ys.lanyu1.mapper.UserScoreMapper;
import com.ys.lanyu1.service.UserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserScoreServiceImpl implements UserScoreService {

    @Autowired
    private UserScoreMapper userScoreMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userScoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserScore userScore) {
        return userScoreMapper.insert(userScore);
    }

    @Override
    public int insertSelective(UserScore userScore) {
        return userScoreMapper.insertSelective(userScore);
    }

    @Override
    public UserScore selectByPrimaryKey(Integer id) {
        return userScoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserScore userScore) {
        return userScoreMapper.updateByPrimaryKeySelective(userScore);
    }

    @Override
    public int updateByPrimaryKey(UserScore userScore) {

        return userScoreMapper.updateByPrimaryKey(userScore);
    }

    @Override
    public int selectByUserId(Integer user_id) {
        return userScoreMapper.selectByUserId(user_id);
    }

    @Override
    public int updateUserScore(Long score, Integer user_id) {
        return userScoreMapper.updateUserScore(score,user_id);
    }
}
