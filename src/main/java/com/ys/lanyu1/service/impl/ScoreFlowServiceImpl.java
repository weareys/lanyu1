package com.ys.lanyu1.service.impl;

import com.ys.lanyu1.domain.ScoreFlow;
import com.ys.lanyu1.mapper.ScoreFlowMapper;
import com.ys.lanyu1.service.ScoreFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreFlowServiceImpl implements ScoreFlowService {

    @Autowired
    private ScoreFlowMapper scoreFlowMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scoreFlowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ScoreFlow scoreFlow) {
        return scoreFlowMapper.insert(scoreFlow);
    }

    @Override
    public int insertSelective(ScoreFlow scoreFlow) {
        return scoreFlowMapper.insertSelective(scoreFlow);
    }

    @Override
    public ScoreFlow selectByPrimaryKey(Integer id) {
        return scoreFlowMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ScoreFlow scoreFlow) {
        return scoreFlowMapper.updateByPrimaryKeySelective(scoreFlow);
    }

    @Override
    public int updateByPrimaryKey(ScoreFlow scoreFlow) {
        return scoreFlowMapper.updateByPrimaryKey(scoreFlow);
    }
}
