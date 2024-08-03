package study.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import study.POJO.Product;
import study.service.CsvToBeanService;

@RestController
public class CsvToBeanController {

	@Autowired
	CsvToBeanService csvToBeanService;
	
	@GetMapping("/getListOfProducts")
	public ResponseEntity<List<Product>> csvToBean(@RequestBody MultipartFile file) throws IOException{
		
		List<Product> products = csvToBeanService.convertCSVtoPojo(file);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
