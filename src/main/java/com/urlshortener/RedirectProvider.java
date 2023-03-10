package com.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;

@Controller
public class RedirectProvider {
	
	private URLRepository repo;
	private TemplateEngine eng;
	
	public RedirectProvider(URLRepository repo, TemplateEngine eng) {
		
		this.repo = repo;
		this.eng = eng;
	}
	
	@GetMapping("/redir/{url}")
	@ResponseBody
	public String redirect(@PathVariable String url) {

		ShortenedURL u = repo.findByShortenedURL(url);
		Context ctx = new Context();
		
		if (null == u) {
			
			return eng.GetTemplateEngine().process("error.html", ctx);
		}
		
		ctx.setVariable("content", "0; url='" + u.getBaseURL() + "'");
		
		return eng.GetTemplateEngine().process("redirect.html", ctx);
	}
}