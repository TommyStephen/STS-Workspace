package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import study.myService.MyService;



@RestController
public class HelloController {

	@Autowired
	private MyService myService;
	
	@GetMapping("/")
	public String sayHi() {
		myService.test();
		return "Hello World";
	}
	
}
