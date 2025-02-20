package com.java_lesson.demo.dao;

import com.java_lesson.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user where id = #{id}")
    User getById(@Param("id") int id);

    @Insert("INSERT INTO user (name, age, sex, weight, height) VALUES (#{name}, #{age}, #{sex}, #{weight}, #{height})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE USER SET name = #{name}, age = #{age} where id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}
