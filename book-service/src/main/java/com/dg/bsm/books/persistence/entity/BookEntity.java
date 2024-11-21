package com.dg.bsm.books.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "bsm_books")
@Data
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column
    private String title;
    @Column
    private String isbn;
    @Column
    private int pageCount;
    @Column
    private Instant publishedDate;
    @Column
    private String thumbnailUrl;

    @Column(columnDefinition = "varchar2(500)")
    private  String shortDescription;

    @Column
    private Set<String> authors;

    @Column
    private Set<String>  categories;


}
