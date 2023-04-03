package com.englishweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{
	@Query(value = "SELECT * FROM video WHERE lessonid = ?1", nativeQuery = true)
	List<Video> findByOrderById(int Id);
	
}
