package com.nareshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.entity.FilesEntity;

public interface FileRepo  extends JpaRepository<FilesEntity,Long>{

}
