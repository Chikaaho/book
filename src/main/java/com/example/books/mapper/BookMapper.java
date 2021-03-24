package com.example.books.mapper;

import com.example.books.pojo.TbBook;

import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;

@Mapper
public interface BookMapper {

    @ApiModelProperty("查询所有书籍信息")
    List<TbBook> selectBook();

    @ApiModelProperty("新增书籍")
    int addBook(@Param("book") TbBook book);

    @ApiModelProperty("修改书籍信息")
    int updateBook(@Param("book_id") long book_id, @Param("book") TbBook book);

    @ApiModelProperty("删除书籍")
    int removeBook(@Param("book_id") long book_id);

    @ApiModelProperty("根据名称查询")
    TbBook selectBookByName(@Param("book_name") String book_name);

    @ApiModelProperty("根据编号查询")
    TbBook selectBookByNumber(@Param("book_number") long book_number);

}
