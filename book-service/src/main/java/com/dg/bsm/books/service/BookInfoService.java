package com.dg.bsm.books.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dg.bsm.books.domain.BookInfo;
import com.dg.bsm.books.domain.BookInfoPage;
import com.dg.bsm.books.persistence.entity.BookEntity;
import com.dg.bsm.books.persistence.repository.BookRepository;

@Service
public class BookInfoService {

    private final BookRepository bookRepository;

    public BookInfoService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookInfoPage getAllBooks(int pageNumber, int pageSize) {

        var pageable = PageRequest.of((pageNumber<1?0:pageNumber-1), pageSize, Sort.Direction.DESC, "publishedDate");
        var page = bookRepository.findAll(pageable);
        var bookInfos = page.getContent().stream().map(this::convertToRecord).toList();
        return new BookInfoPage(page, bookInfos);
    }

    public BookInfo addNewBook(BookInfo bookInfo) {
        BookEntity entity = convertFromRecord(bookInfo);
        return convertToRecord(bookRepository.save(entity));
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
