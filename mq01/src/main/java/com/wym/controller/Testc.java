package com.wym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testc {

	@RequestMapping("/getf")
	@ResponseBody
	public String getFirtst(){
		
		
		return "test";
		
	}
	
}
