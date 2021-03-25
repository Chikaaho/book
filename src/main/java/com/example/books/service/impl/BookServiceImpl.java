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
    public int addBook(TbBook book) {
        return mapper.addBook(book);
    }

    @Override
    @Transactional
    public int updateBook(long book_id, TbBook book) {
        return mapper.updateBook(book_id, book);
    }

    @Override
    @Transactional
    public int removeBook(long book_id) {
        return mapper.removeBook(book_id);
    }

    @Override
    public TbBook selectBookByName(String book_name) {
        return mapper.selectBookByName(book_name);
    }

    @Override
    public TbBook selectBookByNumber(long book_number) {
        return mapper.selectBookByNumber(book_number);
    }

    @Override
    public TbBook selectBookById(long bookId) {
        return mapper.selectBookById(bookId);
    }


}
