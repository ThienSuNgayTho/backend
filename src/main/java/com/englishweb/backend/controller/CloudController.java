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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.backend.service.CloudinaryService;
import com.englishweb.backend.service.VideoService;

import com.englishweb.backend.entity.Video;
import com.englishweb.backend.entity.VideoDTO;
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

	@GetMapping("/list")
	public ResponseEntity<List<Video>> list() {
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
		Video video = new Video((String) result.get("original_filename"), (String) result.get("url"), id, (String) result.get("public_id"));
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

}
