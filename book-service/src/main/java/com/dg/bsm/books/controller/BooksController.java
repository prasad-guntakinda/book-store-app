package com.dg.bsm.books.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dg.bsm.books.domain.BookInfo;
import com.dg.bsm.books.domain.BookInfoPage;
import com.dg.bsm.books.service.BookInfoService;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookInfoService bookInfoService;

    
    public BooksController(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    //TODO: two things to do
    //1. Get Paginated Books
    //2. Group By category and share few books per category
    @GetMapping
    public BookInfoPage getAllBooks(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "size", defaultValue = "10") int size){
        return bookInfoService.getAllBooks(page, size);
    }

    @PostMapping
    public BookInfo addNewBook(@RequestBody BookInfo bookInfo){
        return bookInfoService.addNewBook(bookInfo);
    }
}
