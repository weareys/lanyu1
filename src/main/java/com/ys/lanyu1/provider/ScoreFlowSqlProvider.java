package com.ys.lanyu1.provider;

import com.ys.lanyu1.domain.ScoreFlow;
import org.apache.ibatis.jdbc.SQL;

public class ScoreFlowSqlProvider {

    public String insertSelective(ScoreFlow record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("score_flow");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ScoreFlow record) {
        SQL sql = new SQL();
        sql.UPDATE("score_flow");
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}