package com.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceProvider {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String root() {
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{css}.css")
	public String css(@PathVariable(value = "css") String css) {
						
		return css + ".css";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{js}.js")
	public String js(@PathVariable(value = "js") String js) {
				
		return js + ".js";
	}
}
