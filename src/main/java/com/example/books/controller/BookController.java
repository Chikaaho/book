package com.example.books.controller;

import com.example.books.pojo.TbBook;
import com.example.books.service.impl.BookServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
@ApiModel("书架控制器")
@CrossOrigin
public class BookController {

    private BookServiceImpl bookService;
    @Autowired
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    private final Map<String, Object> booksJson = new HashMap<>();

    @RequestMapping("/addBook")
    public String addBook(@RequestParam String bookName,
                          @RequestParam String bookMsg,
                          @RequestParam long bookStock,
                          @RequestParam long bookNumber) {
        bookService.addBook(bookName, bookMsg, bookStock, bookNumber);
        return "redirect:/books/toIndex";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam long bookId,
                             @RequestParam String bookName,
                             @RequestParam String bookMsg,
                             @RequestParam long stock,
                             @RequestParam long number) {
        bookService.updateBook(bookId, bookName, bookMsg, stock, number);
        return "redirect:/books/toIndex";
    }

    @RequestMapping("/deleteBook")
    @ApiModelProperty("删除书籍")
    public String toDeleteBook(@RequestParam long bookId) {
        bookService.removeBook(bookId);
        return "redirect:/books/toIndex";
    }

    @RequestMapping("/selectBookByNumber")
    public String selectBookByNumber(@RequestParam int bookNumber) {
        booksJson.clear();
        booksJson.put("bookNumber", bookNumber);
        return "forward:/books/toIndex";
    }

    @RequestMapping("/selectBookByName")
    public String selectBookByName(@RequestParam String bookName) {
        booksJson.clear();
        booksJson.put("bookName", bookName);
        return "forward:/books/toIndex";
    }

    /*
     *   以下为json处理servlet
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
    public Map<String, Object> updateBookData() {
        TbBook tbBook = bookService.selectBookById((Integer) booksJson.get("id"));
        booksJson.clear();
        booksJson.put("bookNumber", tbBook.getBookNumber());
        booksJson.put("bookStock", tbBook.getBookStock());
        booksJson.put("bookMsg", tbBook.getBookMsg());
        booksJson.put("bookName", tbBook.getBookName());
        return booksJson;
    }

    @RequestMapping("/selectByNumberData")
    @ResponseBody
    public Map<String, Object> selectBookDataByNumber() {
        TbBook tbBook = bookService.selectBookByNumber((int) booksJson.get("bookNumber"));
        booksJson.clear();
        booksJson.put("bookNumber", tbBook.getBookNumber());
        booksJson.put("bookStock", tbBook.getBookStock());
        booksJson.put("bookMsg", tbBook.getBookMsg());
        booksJson.put("bookName", tbBook.getBookName());
        return booksJson;
    }

    @RequestMapping("/selectByNameData")
    @ResponseBody
    public Map<String, Object> selectBookDataByName() {
        TbBook tbBook = bookService.selectBookByName((String) booksJson.get("bookName"));
        booksJson.clear();
        booksJson.put("bookNumber", tbBook.getBookNumber());
        booksJson.put("bookStock", tbBook.getBookStock());
        booksJson.put("bookMsg", tbBook.getBookMsg());
        booksJson.put("bookName", tbBook.getBookName());
        return booksJson;
    }

    /*
     *   以下为页面跳转servlet
     */

    @RequestMapping("/toIndex")
    @ApiModelProperty("跳转到首页")
    public String toIndex() {
        return "books/index";
    }

    @RequestMapping("/tpAddPage")
    public String toAddPage() {
        return "books/addBooks";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage() {

        return "books/updatePage";
    }

}
