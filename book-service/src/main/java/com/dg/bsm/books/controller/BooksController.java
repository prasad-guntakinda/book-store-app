package com.dg.bsm.books.controller;

import com.dg.bsm.books.domain.BookInfo;
import com.dg.bsm.books.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {


    @Autowired
    private BookInfoService bookInfoService;
    //TODO: two things to do
    //1. Get Paginated Books
    //2. Group By category and share few books per category
    @GetMapping
    public List<BookInfo> getAllBooks(){
        return bookInfoService.getAllBooks();
    }

    @PostMapping
    public BookInfo addNewBook(@RequestBody BookInfo bookInfo){
        return bookInfoService.addNewBook(bookInfo);
    }
}
