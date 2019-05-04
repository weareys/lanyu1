package com.ys.lanyu1.mapper;

import com.ys.lanyu1.domain.ScoreFlow;
import com.ys.lanyu1.provider.ScoreFlowSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ScoreFlowMapper {

    @Delete({
        "delete from score_flow",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);


    @Insert({
        "insert into score_flow (id, score, ",
        "user_id, user_name)",
        "values (#{id,jdbcType=INTEGER}, #{score,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(ScoreFlow record);

    @InsertProvider(type=ScoreFlowSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertSelective(ScoreFlow record);

    @Select({
        "select",
        "id, score, user_id, user_name",
        "from score_flow",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="score", property="score", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    ScoreFlow selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ScoreFlowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ScoreFlow record);

    @Update({
        "update score_flow",
        "set score = #{score,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScoreFlow record);
}