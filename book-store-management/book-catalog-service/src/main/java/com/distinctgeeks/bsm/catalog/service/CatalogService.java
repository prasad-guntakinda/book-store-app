package com.distinctgeeks.bsm.catalog.service;

import com.distinctgeeks.bsm.catalog.domain.BookRecord;
import com.distinctgeeks.bsm.catalog.persistence.entity.BookEntity;
import com.distinctgeeks.bsm.catalog.persistence.repository.BookRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    private final BookRepository bookRepository;

    public CatalogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookRecord> getAllBooks(){
        return bookRepository.findAll().stream().map(this::convertToRecord).collect(Collectors.toList());
    }

    private List<BookRecord> convertToRecords(List<BookEntity> books) {
        List<BookRecord> res = new ArrayList<>();
        return books.stream().map(this::convertToRecord).collect(Collectors.toList());
    }



    public BookRecord addNewBook(BookRecord bookRecord) {
        BookEntity entity = convertFromRecord(bookRecord);
        return  convertToRecord(bookRepository.save(entity));
    }

    private BookEntity convertFromRecord(BookRecord bookRecord) {
        BookEntity entity = new BookEntity();
        entity.setTitle(bookRecord.title());
        entity.setIsbn(bookRecord.isbn());
        entity.setAuthors(bookRecord.authors());
        entity.setCategories(bookRecord.categories());
        entity.setPageCount(bookRecord.pageCount());
        entity.setPublishedDate(bookRecord.publishedDate());
        entity.setThumbnailUrl(bookRecord.thumbnailUrl());
        entity.setShortDescription(bookRecord.shortDescription());
        return entity;
    }

    private BookRecord convertToRecord(BookEntity bookEntity) {

        return new BookRecord(bookEntity.getId(),
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
