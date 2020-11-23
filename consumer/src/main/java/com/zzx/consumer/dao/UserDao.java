package com.zzx.consumer.dao;

import com.zzx.consumer.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Insert("insert into girl (age,high,number) values (#{userEntity.age},#{userEntity.high},#{userEntity.number})")
    int add(@Param("userEntity") UserEntity userEntity);
}
