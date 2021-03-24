package com.example.books.pojo;


import java.util.Objects;

public class TbBook {

    private long bookId;
    private String bookName;
    private String bookMsg;
    private long bookStock;
    private long bookNumber;

    public TbBook() {
    }

    public TbBook(long bookId, String bookName, String bookMsg, long bookStock, long bookNumber) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookMsg = bookMsg;
        this.bookStock = bookStock;
        this.bookNumber = bookNumber;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getBookMsg() {
        return bookMsg;
    }

    public void setBookMsg(String bookMsg) {
        this.bookMsg = bookMsg;
    }


    public long getBookStock() {
        return bookStock;
    }

    public void setBookStock(long bookStock) {
        this.bookStock = bookStock;
    }


    public long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(long bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TbBook)) return false;
        TbBook tbBook = (TbBook) o;
        return getBookId() == tbBook.getBookId() &&
                getBookStock() == tbBook.getBookStock() &&
                getBookNumber() == tbBook.getBookNumber() &&
                Objects.equals(getBookName(), tbBook.getBookName()) &&
                Objects.equals(getBookMsg(), tbBook.getBookMsg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBookName(), getBookMsg(), getBookStock(), getBookNumber());
    }

    @Override
    public String toString() {
        return "TbBooks{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookMsg='" + bookMsg + '\'' +
                ", bookStock=" + bookStock +
                ", bookNumber=" + bookNumber +
                '}';
    }

}
