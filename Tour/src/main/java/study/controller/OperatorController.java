package study.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.model.Operator;
import study.response.OperatorCreationResponse;

@RestController
public class OperatorController {

	@PostMapping("api/tourist/register")
	public OperatorCreationResponse create(@RequestBody Operator operator) {
		OperatorCreationResponse response = new OperatorCreationResponse();
		response.setMessage("Registration successful");
		response.setOperatorId(operator.getId());
		return response;
		
		
		
	}
}
