package com.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceProvider {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String root() {
		
		return "index";
	}
}
