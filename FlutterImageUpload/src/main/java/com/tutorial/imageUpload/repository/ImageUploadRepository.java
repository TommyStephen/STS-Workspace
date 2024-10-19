package com.tutorial.imageUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.imageUpload.model.ImageUpload;

public interface ImageUploadRepository extends JpaRepository<ImageUpload, Integer> {

}
