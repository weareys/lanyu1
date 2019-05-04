package com.ys.lanyu1.provider;

import com.ys.lanyu1.domain.UserScore;
import org.apache.ibatis.jdbc.SQL;

public class UserScoreSqlProvider {

    public String insertSelective(UserScore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_score");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserScore() != null) {
            sql.VALUES("user_score", "#{userScore,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserScore record) {
        SQL sql = new SQL();
        sql.UPDATE("user_score");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserScore() != null) {
            sql.SET("user_score = #{userScore,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}