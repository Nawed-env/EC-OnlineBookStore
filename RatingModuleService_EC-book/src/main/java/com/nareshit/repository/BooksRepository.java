package com.nareshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.entity.bookModule;

@Repository
public interface BooksRepository extends JpaRepository<bookModule, Long> {


}
