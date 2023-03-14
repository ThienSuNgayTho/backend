package com.englishweb.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.englishweb.backend.entity.Video;
import com.englishweb.backend.repository.VideoRepository;

@Service
@Transactional
public class VideoService {
	
	@Autowired
	VideoRepository videoRepository;
	
	public List<Video> list() {
		return videoRepository.findAll();
	}

	public List<Video> listId(int lessonid) {
		return videoRepository.findByOrderById(lessonid);
	}
	
	public void delete(int id) {
		videoRepository.deleteById(id);
	}
	
	public void save(Video video) {
		videoRepository.save(video);
	}
	
	public Optional<Video> getOne(int id) {
		return videoRepository.findById(id);
	}
	
	public boolean exists(int id) {
		return videoRepository.existsById(id);
	}
}
