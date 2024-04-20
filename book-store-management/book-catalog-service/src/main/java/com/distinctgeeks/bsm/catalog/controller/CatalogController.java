package com.distinctgeeks.bsm.catalog.controller;

import com.distinctgeeks.bsm.catalog.domain.BookRecord;
import com.distinctgeeks.bsm.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class CatalogController {


    @Autowired
    private CatalogService catalogService;
    //TODO: two things to do
    //1. Get Paginated Books
    //2. Group By category and share few books per category
    @GetMapping
    public List<BookRecord> getAllBooks(){
        return catalogService.getAllBooks();
    }

    @PostMapping
    public BookRecord addNewBook(@RequestBody BookRecord bookRecord){
        return catalogService.addNewBook(bookRecord);
    }
}
