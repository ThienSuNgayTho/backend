package com.englishweb.backend.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@EnableScheduling
public class CloudinaryService {

	Cloudinary cloudinary;
	private Map<String, String> valuemap = new HashMap();

	public CloudinaryService() {
		valuemap.put("cloud_name", "dcbt4j7z2");
		valuemap.put("api_key", "843997642812471");
		valuemap.put("api_secret", "c1kVbAo1XZxXVjX0Z3sLlLmS4Sc");
		cloudinary = new Cloudinary(valuemap);
		// try {
		// cloudinary.uploader().upload("C:\\Users\\longv\\Downloads\\ab67616d00001e024cdb8fa5892564dab74a7e51.jpg",
		// ObjectUtils.asMap("public_id", "th huy"));
		//// cloudinary.uploader().upload("https://upload.wikimedia.org/wikipedia/commons/a/ae/Olympic_flag.jpg",
		// ObjectUtils.asMap("public_id", "olympic_flag"));
		// } catch (IOException exception) {
		// System.out.println(exception.getMessage());
		// }
	}

	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		// Map result =
		// cloudinary.uploader().upload("C:\\Users\\longv\\Downloads\\335611627_618679816747996_399780896108158274_n.mp4",ObjectUtils.asMap("resource_type","auto"));
		Map params = ObjectUtils.asMap(
				"folder", "EnglishWeb",
				"resource_type", "video");
		Map result = cloudinary.uploader().upload(file, params);
		file.delete();
		return result;
	}

	public Map delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.asMap(
			"folder", "EnglishWeb",
			"resource_type", "video"));
		return result;
	}

	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		return file;
	}

}