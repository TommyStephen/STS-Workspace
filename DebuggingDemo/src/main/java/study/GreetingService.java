package study;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	 public String getGreeting() {
	        // Simulate an error
	        if (true) {
	            throw new RuntimeException("Something went wrong!");
	        }
	        return "Hello, World!";
	    }
}
