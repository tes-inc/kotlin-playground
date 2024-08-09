package com.tes.playground.mapper

import com.tes.playground.domain.User
import org.apache.ibatis.annotations.*

@Mapper
interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    fun findById(id: Long): User

    @Select("SELECT * FROM users")
    fun findAll(): List<User>

    @Insert("INSERT INTO users(name, email) VALUES(#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(user: User)

    @Update("UPDATE users SET name=#{name}, email=#{email} WHERE id=#{id}")
    fun update(user: User)

    @Delete("DELETE FROM users WHERE id=#{id}")
    fun deleteById(id: Long)
}
