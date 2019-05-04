package com.ys.lanyu1.mapper;

import com.ys.lanyu1.domain.UserScore;
import com.ys.lanyu1.provider.UserScoreSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserScoreMapper {

    @Delete({
        "delete from user_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_score (id, user_id, ",
        "user_score, name)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{userScore,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(UserScore record);

    @InsertProvider(type=UserScoreSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertSelective(UserScore record);

    @Select({
        "select",
        "id, user_id, user_score, name",
        "from user_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_score", property="userScore", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    UserScore selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserScoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserScore record);

    @Update({
        "update user_score",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "user_score = #{userScore,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserScore record);

    @Select("select count(1) from user_score where user_id=#{user_id}")
    int selectByUserId(Integer user_id);

    @Update("update user_score set user_score=user_score+#{score} where user_id=#{user_id} ")
    int updateUserScore(Long score,Integer user_id);
}