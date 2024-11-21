package com.dg.bsm.books.domain;

import java.time.Instant;
import java.util.Set;

public record BookInfo(int id,
                       String title,
                       String isbn,
                       int pageCount,
                       Instant publishedDate,
                       String thumbnailUrl,
                       String shortDescription,
                       Set<String>authors,
                       Set<String>  categories) {
}
