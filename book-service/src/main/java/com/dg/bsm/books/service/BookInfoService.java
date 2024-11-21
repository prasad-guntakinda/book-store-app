package com.dg.bsm.books.service;

import com.dg.bsm.books.persistence.entity.BookEntity;
import com.dg.bsm.books.persistence.repository.BookRepository;
import com.dg.bsm.books.domain.BookInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookInfoService {

    private final BookRepository bookRepository;

    public BookInfoService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookInfo> getAllBooks(){
        return bookRepository.findAll().stream().map(this::convertToRecord).collect(Collectors.toList());
    }

    private List<BookInfo> convertToRecords(List<BookEntity> books) {
        List<BookInfo> res = new ArrayList<>();
        return books.stream().map(this::convertToRecord).collect(Collectors.toList());
    }



    public BookInfo addNewBook(BookInfo bookInfo) {
        BookEntity entity = convertFromRecord(bookInfo);
        return  convertToRecord(bookRepository.save(entity));
    }

    private BookEntity convertFromRecord(BookInfo bookInfo) {
        BookEntity entity = new BookEntity();
        entity.setTitle(bookInfo.title());
        entity.setIsbn(bookInfo.isbn());
        entity.setAuthors(bookInfo.authors());
        entity.setCategories(bookInfo.categories());
        entity.setPageCount(bookInfo.pageCount());
        entity.setPublishedDate(bookInfo.publishedDate());
        entity.setThumbnailUrl(bookInfo.thumbnailUrl());
        entity.setShortDescription(bookInfo.shortDescription());
        return entity;
    }

    private BookInfo convertToRecord(BookEntity bookEntity) {

        return new BookInfo(bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getIsbn(),
                bookEntity.getPageCount(),
                bookEntity.getPublishedDate(),
                bookEntity.getThumbnailUrl(),
                bookEntity.getShortDescription(),
                bookEntity.getAuthors(),
                bookEntity.getCategories());
    }


}
