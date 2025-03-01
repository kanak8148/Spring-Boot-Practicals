package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.DemoResponse;

@RestController
@RequestMapping(value = "Demo")
public class DemoCtl {
	
	public String dispaly() {
		return "Spring Boot Practicals Application";
	}
	@GetMapping("test")
	public DemoResponse test() {
		
		DemoResponse res =  new DemoResponse();
		res.setName("Spring boot Practicals");
		res.setStatus("Testing sussesful");
		
		return res ;
		
		
		
	}

}
