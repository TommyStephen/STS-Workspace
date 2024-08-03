package study.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.model.School;
import study.model.Principal;

@RestController
public class Controller {

	@PostMapping("/save")
	public ResponseEntity<?> createPrincipal(@RequestBody Principal principal){
		
		return ResponseEntity.ok(principal);
	}
	
	@GetMapping("/send")
	public String send(){
		
		return "Success";
	}
	
	@PostMapping("save-school")
	public ResponseEntity<?> createSchool(@RequestBody School school){
		return ResponseEntity.ok(school);
	}
}












