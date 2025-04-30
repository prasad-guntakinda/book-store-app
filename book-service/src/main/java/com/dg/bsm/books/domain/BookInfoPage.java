package com.dg.bsm.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import com.dg.bsm.books.persistence.entity.BookEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookInfoPage {

    private final List<BookInfo> books;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private int currentPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasNextPage;

    public BookInfoPage(Page<BookEntity> page, List<BookInfo> books) {
        this.books = books;
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.currentPage = page.getNumber() + 1;
        this.isFirstPage = page.isFirst();
        this.isLastPage = page.isLast();
        this.hasNextPage = page.hasNext();
    }
}
