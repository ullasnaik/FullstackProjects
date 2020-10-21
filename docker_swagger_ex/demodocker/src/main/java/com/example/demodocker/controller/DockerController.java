package com.example.demodocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

	@GetMapping("/home")
	public String getMyName()
	{
		return "Welcome to Docker Containerization";
		
	}
}
