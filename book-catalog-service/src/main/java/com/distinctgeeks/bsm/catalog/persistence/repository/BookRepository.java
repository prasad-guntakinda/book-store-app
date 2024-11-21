package com.distinctgeeks.bsm.catalog.persistence.repository;

import com.distinctgeeks.bsm.catalog.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
