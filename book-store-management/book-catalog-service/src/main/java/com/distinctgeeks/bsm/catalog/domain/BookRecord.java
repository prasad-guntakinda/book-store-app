package com.distinctgeeks.bsm.catalog.domain;

import jakarta.persistence.Id;

import java.time.Instant;
import java.util.Set;

public record BookRecord(int id,
                         String title,
                         String isbn,
                         int pageCount,
                         Instant publishedDate,
                         String thumbnailUrl,
                         String shortDescription,
                         Set<String>authors,
                         Set<String>  categories) {
}
