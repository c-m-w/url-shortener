package com.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;

@Controller
public class RedirectProvider {
	
	private URLRepository repo;
	
	public RedirectProvider(URLRepository repo) {
		
		this.repo = repo;
	}
	
	@GetMapping("/redir/{url}")
	@ResponseBody
	public String redirect(@PathVariable String url) {

		ShortenedURL u = repo.findByShortenedURL(url); // .orElseThrow()
		Context ctx = new Context();
		
		ctx.setVariable("content", "0; url='" + u.getBaseURL() + "'");
		
		return TemplateEngine.GetTemplateEngine().process("redirect.html", ctx);
	}
}