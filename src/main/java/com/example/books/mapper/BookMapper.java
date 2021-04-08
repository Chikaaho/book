package com.example.books.mapper;

import com.example.books.pojo.TbBook;

import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @ApiModelProperty("查询所有书籍信息")
    List<TbBook> selectBook();

    @ApiModelProperty("新增书籍")
    int addBook(@Param("bookName") String bookName
            , @Param("bookMsg") String bookMsg
            , @Param("bookStock") long bookStock
            , @Param("bookNumber") long bookNumber);

    @ApiModelProperty("修改书籍信息")
    int updateBook(@Param("bookId") long bookId
            ,@Param("bookName") String bookName
            , @Param("bookMsg") String bookMsg
            , @Param("bookStock") long bookStock
            , @Param("bookNumber") long bookNumber);

    @ApiModelProperty("删除书籍")
    int removeBook(@Param("bookId") long bookId);

    @ApiModelProperty("根据名称查询")
    TbBook selectBookByName(@Param("bookName") String bookName);

    @ApiModelProperty("根据编号查询")
    TbBook selectBookByNumber(@Param("bookNumber") long bookNumber);

    @ApiModelProperty("Id查询")
    TbBook selectBookById(@Param("bookId") long bookId);

}
