package com.ys.lanyu1.controller;


import com.ys.lanyu1.service.RankingService;
import com.ys.lanyu1.service.ScoreFlowService;
import com.ys.lanyu1.support.SimpleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rank")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @RequestMapping("/add")
    public SimpleResult  addScore(@RequestParam(value = "user_id" ,required = true) Integer user_id,
                                  @RequestParam(value = "name" ,required = true) String  name,
                                  @RequestParam(value = "score" ,required = true) Long score){

        return rankingService.addScore(user_id,name,score);
    }





}
