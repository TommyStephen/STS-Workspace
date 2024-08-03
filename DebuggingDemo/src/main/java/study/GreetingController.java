package study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
    private GreetingService greetingService;

	@GetMapping("/greeting")
    public String getGreeting() {
        try {
            return greetingService.getGreeting();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
