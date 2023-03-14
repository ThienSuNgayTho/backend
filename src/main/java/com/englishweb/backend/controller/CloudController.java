package com.englishweb.backend.controller;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.backend.service.CloudinaryService;
import com.englishweb.backend.service.ImageService;
import com.englishweb.backend.entity.Video;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudController {

	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	ImageService imageService;

	@GetMapping("/list")
	public ResponseEntity<List<Video>> list() {
		List<Video> list = imageService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
		
		Map result = cloudinaryService.upload(multipartFile);
		Video image = new Video((String)result.get("original_filename"), (String)result.get("url"),
				(String)result.get("public_id"));

		imageService.save(image);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// @DeleteMapping("/delete/{id}")
	// public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
	// 	if(!imageService.exists(id)) {
	// 		return new ResponseEntity(HttpStatus.NOT_FOUND);
	// 	}
	// 	Image image = imageService.getOne(id).get();
	// 	Map result = cloudinaryService.delete(image.getImageId());
	// 	imageService.delete(id);
	// 	return new ResponseEntity(result, HttpStatus.OK);
	// }
}
