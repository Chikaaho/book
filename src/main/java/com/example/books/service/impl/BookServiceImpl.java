package com.example.books.service.impl;

import com.example.books.mapper.BookMapper;
import com.example.books.pojo.TbBook;
import com.example.books.service.BookService;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper mapper;

    @Override
    public List<TbBook> selectBook() {
        return mapper.selectBook();
    }

    @Override
    @Transactional
    public int addBook(@Param("bookName") String bookName
            , @Param("bookMsg") String bookMsg
            , @Param("bookStock") long bookStock
            , @Param("bookNumber") long bookNumber) {
        return mapper.addBook(bookName, bookMsg, bookStock, bookNumber);
    }

    @Override
    @Transactional
    public int updateBook(@Param("bookId") long bookId
            , @Param("bookName") String bookName
            , @Param("bookMsg") String bookMsg
            , @Param("bookStock") long bookStock
            , @Param("bookNumber") long bookNumber) {
        return mapper.updateBook(bookId, bookName, bookMsg, bookStock, bookNumber);
    }

    @Override
    @Transactional
    public int removeBook(long bookId) {
        return mapper.removeBook(bookId);
    }

    @Override
    public TbBook selectBookByName(String bookName) {
        return mapper.selectBookByName(bookName);
    }

    @Override
    public TbBook selectBookByNumber(long bookNumber) {
        return mapper.selectBookByNumber(bookNumber);
    }

    @Override
    public TbBook selectBookById(long bookId) {
        return mapper.selectBookById(bookId);
    }


}
