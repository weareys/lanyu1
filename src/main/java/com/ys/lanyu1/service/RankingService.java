package com.ys.lanyu1.service;

import com.ys.lanyu1.domain.Rank;
import com.ys.lanyu1.domain.ScoreFlow;
import com.ys.lanyu1.domain.UserScore;
import com.ys.lanyu1.mapper.ScoreFlowMapper;
import com.ys.lanyu1.mapper.UserScoreMapper;
import com.ys.lanyu1.support.SimpleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@CacheConfig(cacheNames = "rankCache")
@Transactional(propagation=Propagation.REQUIRED,readOnly = false,rollbackFor=Exception.class)
public class RankingService {

    private  static  final  String  USER_RANK_KEY="LANYU";

    @Autowired
    private UserScoreMapper userScoreMapper;

    @Autowired
    private ScoreFlowMapper scoreFlowMapper;

    @Autowired
    private RedisTemplate  redisTemplate;

    @Autowired
    private RedisService  redisService;

    public SimpleResult addScore(Integer user_id, String name, Long score){
        ScoreFlow scoreFlow=new ScoreFlow();
        scoreFlow.setScore(score);
        scoreFlow.setUserName(name);
        scoreFlow.setUserId(user_id);
       if (!findUserExist(user_id)){
           UserScore userScore=new UserScore();
           userScore.setUserId(user_id);
           userScore.setUserScore(score);
           userScore.setName(name);
           userScoreMapper.insertSelective(userScore);
           scoreFlowMapper.insertSelective(scoreFlow);
           redisService.zAdd(USER_RANK_KEY,user_id.toString(),score);
       }else{
           userScoreMapper.updateUserScore(score,user_id);
           scoreFlowMapper.insertSelective(scoreFlow);
       }
       return SimpleResult.buildSuccess("用户积分添加成功");
    }

    /**
     * 查找用户是否参与积分活动
     * @param user_id
     * @return
     */
    @Cacheable(keyGenerator = "genValueKeyGenerator")
    public boolean findUserExist(Integer user_id){
        Integer count=userScoreMapper.selectByUserId(user_id);
        if(count ==1){
            redisService.set(user_id.toString(),count);
        }
        return  1==count;
    }

    /**
     * 根据user_id查找参与积分用户信息
     * @param user_id
     * @return
     */
    @Cacheable(keyGenerator = "genValueKeyGenerator")
    public UserScore findUserScoreInfoById(Integer user_id){

        return  userScoreMapper.selectByPrimaryKey(user_id);
    }

    /**
     * 添加积分
     * @param score
     * @return
     */
    @CachePut(keyGenerator = "genValueKeyGenerator")
    public boolean updateUserScore(Long score,Integer user_id){
       return  1==userScoreMapper.updateUserScore(score,user_id);
    }
}
