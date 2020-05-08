package com.wegame.mapper;

import com.wegame.model.Room;
import com.wegame.provider.RoomSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface RoomMapper {
    @Insert({
        "insert into t_room (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "NAME, SERIAL, STATUS)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{serial,jdbcType=INTEGER}, #{status,jdbcType=INTEGER})"
    })
    int insert(Room record);

    @InsertProvider(type= RoomSqlProvider.class, method="insertSelective")
    int insertSelective(Room record);
}
