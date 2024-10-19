package com.tutorial.imageUpload.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.imageUpload.model.ImageUpload;
import com.tutorial.imageUpload.repository.ImageUploadRepository;
import com.tutorial.imageUpload.response.ImageUploadResponse;
import com.tutorial.imageUpload.response.ResponseMapper;

@Service
public class ImageUploadService {

	private static final String UPLOAD_DIR = "C:\\Data\\FlutterProjects\\flutter_image_upload\\flutter_image_upload\\assets\\images\\";
	

	@Autowired
	ImageUploadRepository imageUploadRepository;

	public List<ImageUploadResponse> findAll() {
		
		List<ImageUpload> list = imageUploadRepository.findAll();
		List<ImageUploadResponse> response = new ArrayList<>();
		for(ImageUpload entity : list) {
			ImageUploadResponse resp = new ImageUploadResponse();
			resp = ResponseMapper.entityToResponseMapper(entity);
			response.add(resp);
		}
		return response;
	}

	public ImageUploadResponse saveProduct(MultipartFile file, String name, String description, int price) {

		String multipartFile = StringUtils.cleanPath(file.getOriginalFilename());
		if (multipartFile.contains("..")) {
			System.out.println("File selected is not a valid one");
		}
		ImageUpload product = new ImageUpload();
		String imageFullPath = UPLOAD_DIR + file.getOriginalFilename();

		try {
			product.setImage(file.getBytes());
		} catch (IOException e) {

			e.printStackTrace();
		}
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImagePath(file.getOriginalFilename());
		product.setImageFullPath(imageFullPath);
		product.setImageContentType(file.getContentType());
		
		ImageUpload savedProduct = imageUploadRepository.save(product);

		// send the image file to the directory
		try {
			file.transferTo(new File(imageFullPath));
		} catch (IllegalStateException | IOException e) {

			e.printStackTrace();
		}
		ImageUploadResponse response = ResponseMapper.entityToResponseMapper(savedProduct);
		return response;
	}

	public ImageUploadResponse update(int id, MultipartFile file, String name, String description, int price) {

		Optional<ImageUpload> obj = imageUploadRepository.findById(id);
		ImageUpload product = new ImageUpload();
		
		
		if (obj.isPresent()) {
			product = obj.get();
		}
		if (file != null && !file.isEmpty()) {
			try {
				product.setImage(file.getBytes());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		String imageFullPath = UPLOAD_DIR + file.getOriginalFilename();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImagePath(file.getOriginalFilename());
		product.setImageFullPath(imageFullPath);
		product.setImageContentType(file.getContentType());
		
		ImageUpload updatedProduct = imageUploadRepository.save(product);

		// send the image file to the directory
		try {
			file.transferTo(new File(imageFullPath));
			
		} catch (IllegalStateException | IOException e) {

			e.printStackTrace();
		}
		ImageUploadResponse response = ResponseMapper.entityToResponseMapper(updatedProduct);
		return response;

	}

	public ImageUploadResponse findProductById(int id) {
		
		Optional<ImageUpload> entity = imageUploadRepository.findById(id);
		
		ImageUpload product = null;
		if(entity.isPresent()) {
			product = entity.get();
		}
		ImageUploadResponse response = ResponseMapper.entityToResponseMapper(product);
		return response;
	}

	

}
