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
public class ImageService {
	
	@Autowired
	VideoRepository imageRepository;
	
	public List<Video> list() {
		return imageRepository.findByOrderById();
	}
	
	public void delete(int id) {
		imageRepository.deleteById(id);
	}
	
	public void save(Video image) {
		imageRepository.save(image);
	}
	
	public Optional<Video> getOne(int id) {
		return imageRepository.findById(id);
	}
	
	public boolean exists(int id) {
		return imageRepository.existsById(id);
	}
}
