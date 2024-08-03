package study.myService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	 @Value("${spring.application.name}")
	    private String applicationName;
	 
	 @Value("${SOMETEXT}")
	    private String demo;
	  
	    
	  
	    public void test() {
	      System.out.println("name: " + this.applicationName);
	      System.out.println(demo);
	      
	    }
}
