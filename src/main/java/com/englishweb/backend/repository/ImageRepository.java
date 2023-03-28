package com.englishweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{
	@Query(value = "SELECT * FROM image WHERE courseid = ?1", nativeQuery = true)
	List<Image> findByOrderById(int Id);
	
}
