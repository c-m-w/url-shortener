package com.urlshortener;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIProvider {
	
	public record Message(String data, boolean success, String message) { };
	
	private URLRepository repo;
	private ConnectionVerifier verifier;
	
	public APIProvider(URLRepository repo) {
		
		this.repo = repo;
		this.verifier = new ConnectionVerifier();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/api/shorten", method = RequestMethod.POST)
    public ShortenedURL shorten(@RequestBody ShortenedURL url) {
		
		if (!verifier.Verify(url.getBaseURL())) {
			
			ShortenedURL error = new ShortenedURL("");
			
			error.setShortenedURL("error");
			
			return error;
		}
		
		if (null != repo.findByShortenedURL(url.getShortenedURL())) {
			
			return shorten(new ShortenedURL(url.getBaseURL()));
		}
		
		return repo.saveAndFlush(url);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/url/{url}")
	ShortenedURL one(@PathVariable String url) {
		
		return repo.findByShortenedURL(url);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/url")
	List<ShortenedURL> all() {
		
		return repo.findAll();
	}
}
