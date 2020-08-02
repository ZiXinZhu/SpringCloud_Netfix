package com.zzx.consumer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Insert("insert into girl (age,high) values (#{age},#{high})")
    int add(@Param("age") int age, @Param("high") int high);

}
