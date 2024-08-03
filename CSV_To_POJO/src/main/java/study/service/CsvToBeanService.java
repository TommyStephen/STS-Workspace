package study.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import study.POJO.Product;

@Service
public class CsvToBeanService {

	public List<Product> convertCSVtoPojo(MultipartFile file) throws IOException{
		
		List<Product> list = new ArrayList<>();
	
		InputStream inputStream = file.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		String line;
		boolean skipHeader = true;
		while((line = br.readLine())!= null) {
			if(skipHeader) {
				skipHeader = false;
				continue;
			}
			System.out.println(line);
			String [] field = line.split(",", -1);
			
			String id = field[0].trim();
			String name = field[1].trim();/*if there is any comma inside
			the data in the name field this will not work */
			String price = field[2].trim();
			Product product = new Product(id, name, price);
			list.add(product);
			
		}
		
		
		return list;
	}	
}
//public Boolean validateFileAgainstPONumber(MultipartFile file) throws IOException {
//String poNumber = null;
//
//get byte array from the multipart file
//byte [] fileContents = file.getBytes();
//
//convert byte array into string
//String data = new String (fileContents, StandardCharsets.UTF_8);
//
//Split the string into string array
//String [] lines = data.split("\\r?\\n");
//
//check if there is a second line
//if(lines.length>= 2){
//  split the second line into a string array
//  String [] secondLine = lines[1].split(",");
//  if(secondLine[3] !=null && !secondLine[3].isEmpty()){
//      poNumber = secondLine[3];
//      System.out.println("Purchase Order Id "+poNumber);
//}


