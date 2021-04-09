package com.example.books.mapper;

import com.example.books.pojo.TbUser;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    @ApiModelProperty("验证用户")
    TbUser selectUser(@Param("username") String username, @Param("password") String password);

    @ApiModelProperty("注册")
    int registUser(@Param("username") String username
            , @Param("password") String password
            , @Param("userNumber") long userNumber
            , @Param("classname") String classname);

    @ApiModelProperty("修改用户信息")
    int updateUser(@Param("user_id") long user_id
            , @Param("username") String username
            , @Param("password") String password
            , @Param("userNumber") long userNumber
            , @Param("classname") String classname);

    @ApiModelProperty("注销用户")
    int removeUser(@Param("user_id") long user_id);

    @ApiModelProperty("根据名称查询")
    TbUser selectUserByName(@Param("username") String username);

    @ApiModelProperty("根据学号查询")
    TbUser selectUserByNumber(@Param("user_number") long user_number);

    @ApiModelProperty("根据班级查询")
    TbUser selectUserByClassName(@Param("classname") String classname);

}
