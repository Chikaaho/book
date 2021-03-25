package com.example.books.controller;

import com.example.books.pojo.TbBook;
import com.example.books.service.impl.BookServiceImpl;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
@ApiModel("书架控制器")
@CrossOrigin
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    private final Map<String, Object> booksJson = new HashMap<String, Object>();

    @RequestMapping("/addBook")
    public String addBook(@RequestParam String bookName,
                          @RequestParam String bookMsg,
                          @RequestParam long stock,
                          @RequestParam long number) {
        TbBook tbBook = new TbBook(bookName, bookMsg, stock, number);
        bookService.addBook(tbBook);
        return "operation/middle";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(@RequestParam long bookId) {
        TbBook tbBook = bookService.selectBookById(bookId);
        booksJson.clear();
        booksJson.put("bookNumber", tbBook.getBookNumber());
        booksJson.put("bookStock", tbBook.getBookStock());
        booksJson.put("bookMsg", tbBook.getBookMsg());
        booksJson.put("bookName", tbBook.getBookName());
        return "books/updatePage";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam long bookId,
                             @RequestParam String bookName,
                             @RequestParam String bookMsg,
                             @RequestParam long stock,
                             @RequestParam long number) {
        bookService.updateBook(bookId, new TbBook(bookName, bookMsg, stock, number));
        return "books/index";
    }

    /*
    *   以下为json处理
    */

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<TbBook> selectAllBook(Model model) {
        List<TbBook> tbBooks = bookService.selectBook();
        if (tbBooks == null) {
            model.addAttribute("BOOK_NULL_MESSAGE", "啊哦，书架上现在没有书哦");
            return null;
        }
        return tbBooks;
    }

    @RequestMapping("/updateBookData")
    @ResponseBody
    public Map<String, Object> bookData() {
        return booksJson;
    }

    /*
    *   以下为页面跳转服务
    */

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "books/index";
    }

    @RequestMapping("/tpAddPage")
    public String toAddPage() {
        return "books/addBooks";
    }

}
