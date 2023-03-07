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
	
	public APIProvider(URLRepository repo) {
		
		this.repo = repo;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/api/shorten", method = RequestMethod.POST)
    public ShortenedURL shorten(@RequestBody ShortenedURL url) {
		
		return repo.saveAndFlush(url);
	}
	
	@GetMapping("/api/url/{url}")
	ShortenedURL one(@PathVariable String url) {
		
		return repo.findByShortenedURL(url); // .orElseThrow()
	}
	
	@GetMapping("/api/url")
	List<ShortenedURL> all() {
		
		return repo.findAll();
	}
}
