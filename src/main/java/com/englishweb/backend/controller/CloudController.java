package com.englishweb.backend.controller;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.backend.service.CloudinaryService;
import com.englishweb.backend.service.ImageService;
import com.englishweb.backend.service.VideoService;

import com.englishweb.backend.entity.Video;
import com.englishweb.backend.entity.VideoDTO;
import com.englishweb.backend.repository.VideoRepository;
import com.englishweb.backend.entity.Image;
import com.englishweb.backend.entity.ImageDTO;
import com.englishweb.backend.entity.Lesson;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudController {

	private Lesson lesson = new Lesson();

	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	VideoService videoService;

	@Autowired
	ImageService imageService;

	// Image

	@GetMapping("/image/list")
	public ResponseEntity<List<Image>> list() {
		List<Image> list = imageService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/image/list/{id}")
	public ResponseEntity<List<ImageDTO>> listImageById(@PathVariable(name = "id") int id) {
		List<Image> lists = imageService.listId(id);
		List<ImageDTO> listDTO = new ArrayList<>();
		for (Image list : lists) {
			listDTO.add(new ImageDTO(list.getId(), list.getImageName(), list.getImageURL()));
		}
		return new ResponseEntity(listDTO, HttpStatus.OK);
	}

	@DeleteMapping("/image/delete/{id}")
	public ResponseEntity<?> deleteImage(@PathVariable("id") int id) throws IOException {
		if (!imageService.exists(id)) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		Image image = imageService.getOne(id).get();
		Map result = cloudinaryService.deleteImage(image.getImageId());
		imageService.delete(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@PostMapping("/image/upload/{id}")
	public ResponseEntity<?> uploadImage(@RequestParam MultipartFile multipartFile, @PathVariable int id)
			throws IOException {
		Map result = cloudinaryService.uploadImage(multipartFile);
		Image image = new Image((String) result.get("original_filename"), (String) result.get("url"),
				(String) result.get("public_id"), id);
		imageService.save(image);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// Video

	@GetMapping("/list")
	public ResponseEntity<List<Video>> listVideo() {
		List<Video> list = videoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/list/{id}")
	public ResponseEntity<List<VideoDTO>> listById(@PathVariable(name = "id") int id) {
		List<Video> lists = videoService.listId(id);
		List<VideoDTO> listDTO = new ArrayList<>();
		for (Video list : lists) {
			listDTO.add(new VideoDTO(list.getId(), list.getVideoname(), list.getVideoURL()));
		}
		return new ResponseEntity(listDTO, HttpStatus.OK);
	}

	@PostMapping("/upload/{id}")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @PathVariable int id)
			throws IOException {
		Map result = cloudinaryService.upload(multipartFile);
		Video video = new Video((String) result.get("original_filename"), (String) result.get("url"), id,
				(String) result.get("public_id"));
		videoService.save(video);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!videoService.exists(id)) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		Video video = videoService.getOne(id).get();
		Map result = cloudinaryService.delete(video.getVideoId());
		videoService.delete(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// @PutMapping("/update/{id}")
	// public ResponseEntity<Video> update(@PathVariable("id") int id, @RequestParam
	// Video video,
	// @RequestParam MultipartFile multipartFile)
	// throws IOException {
	// Video video = videoService.getOne(id).get();
	// Map result = cloudinaryService.delete(video.getVideoId());
	// result = cloudinaryService.upload(multipartFile);
	// video = new Video((String) result.get("original_filename"), (String)
	// result.get("url"), id,
	// (String) result.get("public_id"));
	// video.setLesson(video.getLesson());
	// videoService.save(video);
	// return new ResponseEntity(HttpStatus.OK);
	// }
}
