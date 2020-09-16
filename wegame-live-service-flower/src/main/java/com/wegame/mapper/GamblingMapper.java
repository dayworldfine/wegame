package com.wegame.mapper;

import com.wegame.dto.RoomMsgDto;
import com.wegame.model.Gambling;
import com.wegame.provider.GamblingSqlProvider;
import com.wegame.vo.RoomMsgVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface GamblingMapper {
    @Insert({
        "insert into t_gambling (id, create_time, ",
        "update_time, version, ",
        "room_id, gambling_status, ",
        "integral_fundus, integral_sum)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{roomId,jdbcType=BIGINT}, #{gamblingStatus,jdbcType=TINYINT}, ",
        "#{integralFundus,jdbcType=BIGINT}, #{integralSum,jdbcType=BIGINT})"
    })
    int insert(Gambling record);

    @InsertProvider(type= GamblingSqlProvider.class, method="insertSelective")
    int insertSelective(Gambling record);

    /**
     * 查询所有牌局
     * @return
     */
    @Select("select * ,(select * from t_gambling+details) as gamblingSet from t_gambling")
    @Results(id = "GamblingText",value = {
            @Result(column="id", property="id", id=true),
            @Result(column="create_time", property="createTime"),
            @Result(column="update_time", property="updateTime"),
            @Result(column="version", property="version"),
            @Result(column="room_id", property="roomId"),
            @Result(column="gambling_status", property="gamblingStatus"),
            @Result(column="integral_fundus", property="integralFundus"),
            @Result(column="integral_sum", property="integralSum"),
            @Result(column ="id",property = "gamblingSet",many=@Many(select="com.wegame.mapper.GamblingDetailsMapper.queryByGamblingId"))
    })
    Gambling singleById();

    /**
     *  //这里@ResultMap里面的值指向上面的 id
     * @return
     */
    @Select("select * from t_gambling")
    @ResultMap(value="GamblingText")
    Gambling singleByIdsss();


    /*查询房间信息*/
    @Select("SELECT \n" +
            "id as gamblingId,\n" +
            "room_id as roomId,\n" +
            "gambling_status as gamblingStatus,\n" +
            "integral_fundus as integralFundus,\n" +
            "integral_sum as integralSum\n" +
            "FROM\n" +
            "t_gambling \n" +
            "WHERE room_id = ${roomId,jdbcType=BIGINT}\n" +
            "AND gambling_status=0\n" +
            "LIMIT 1")
    RoomMsgDto getRoomMsgByRoomId(int roomId);
}
