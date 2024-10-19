package com.tutorial.imageUpload.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.imageUpload.repository.ImageUploadRepository;
import com.tutorial.imageUpload.response.ImageUploadResponse;
import com.tutorial.imageUpload.service.ImageUploadService;


@CrossOrigin
@RestController
public class ImageUploadController {

	@Autowired
	private ImageUploadService imageUploadService;
	
	@Autowired
	private ImageUploadRepository imageUploadRepository;
	
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<?> saveRecord(@RequestParam("file") MultipartFile file,
	                                         @RequestParam("name") String name,
	                                         @RequestParam("description") String description,
	                                         @RequestParam("price") int price) throws IOException {
	    
		ImageUploadResponse savedProduct = imageUploadService.saveProduct(file, name, description, price);
	    
	    return new ResponseEntity<>(savedProduct,  HttpStatus.OK);	
	}
	
	@GetMapping("/findAll")
	@ResponseBody
	public ResponseEntity<?> findAll(){
		List<ImageUploadResponse> allProducts = imageUploadService.findAll();
		return new ResponseEntity<>(allProducts,  HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id,
	                            @RequestParam(value = "file", required = false) MultipartFile file,
	                            @RequestParam("name") String name,
	                            @RequestParam("description") String description,
	                            @RequestParam("price") int price) throws IOException {
		
	    ImageUploadResponse updatedProduct = imageUploadService.update(id, file, name, description, price);
	    return new ResponseEntity<>(updatedProduct,  HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		imageUploadRepository.deleteById(id);
	    return "Product deleted successfully";
	}
	
	@GetMapping("/findProductById/{id}")
	public ResponseEntity<?> findProductById(@PathVariable int id){
		ImageUploadResponse response = imageUploadService.findProductById(id);
		return new ResponseEntity<>(response,  HttpStatus.OK);
	}
	
	
	
}
