package com.sr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET, value = "/api/sr")
	public String sayHello()
	{
		return "Swagger Implementation...!!!";
	}

	@GetMapping("/api/posts/{name}")
	public String partofString(@PathVariable("name") String name)
	{
		return name.substring(2,6);
	}
	
}
