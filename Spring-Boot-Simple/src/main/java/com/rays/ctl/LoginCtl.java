package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.UserDTO;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl {

	@Autowired
	public UserService service;

	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody UserRegistrationForm form) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());

		long pk = service.add(dto);

		res.addData(pk);
		res.addMessage("Data Registered Successfully..!!");
		return res;
	}
	@GetMapping("testOrsResponse")
	public ORSResponse testOrsResponse() {

		ORSResponse res = new ORSResponse();

		res.setSuccess(true);

		res.addMessage("data added successfully");

		
		  UserDTO dto = new UserDTO(); dto.setId(1l); dto.setFirstName("abc");
		  dto.setLastName("xyz"); dto.setLoginId("abc@gmail.com");
		  dto.setPassword("1234");
		  
		  res.addData(dto);
		  
		  UserDTO dto1 = new UserDTO(); dto1.setId(2l); dto1.setFirstName("abc");
		  dto1.setLastName("xyz"); dto1.setLoginId("abc@gmail.com");
		  dto1.setPassword("1234");
		  
		  UserDTO dto2 = new UserDTO(); dto2.setId(3l); dto2.setFirstName("abc");
		  dto2.setLastName("xyz"); dto2.setLoginId("abc@gmail.com");
		  dto2.setPassword("1234");
		  
		  UserDTO dto3 = new UserDTO(); dto3.setId(4l); dto3.setFirstName("abc");
		  dto3.setLastName("xyz"); dto3.setLoginId("abc@gmail.com");
		  dto3.setPassword("1234");
		  
		  List list = new ArrayList(); list.add(dto1); list.add(dto2); list.add(dto3);
		  
		  res.addData(list);
		 
		Map errors = new HashMap();
		errors.put("firstName", "First Name is required");
		errors.put("lastName", "Last Name is required");
		errors.put("loginId", "Login ID is required");
		errors.put("password", "Password is required");

		res.addInputError(errors);

		//res.addResult("userList", list);

		return res;
	}
}
	
