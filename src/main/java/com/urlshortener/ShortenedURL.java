package com.urlshortener;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SHORTENED_URL")
public class ShortenedURL {

	private final static int URL_LEN = 8;
	private @Id String shortenedURL;
	private String baseURL;
	
	public ShortenedURL() {	}
	
	public ShortenedURL(String baseURL) {

		shorten();
		this.baseURL = baseURL;
	}
	
	public void shorten() {
		
		this.shortenedURL = RandomString.Generate(URL_LEN);
	}
		
	public String getShortenedURL() {
		
		return this.shortenedURL;
	}

	public String getBaseURL() {
		
		return this.baseURL;
	}

	public void setShortenedURL(String shortenedURL) {
		
		this.shortenedURL = shortenedURL;
	}

	public void setBaseURL(String baseURL) {
		
		shorten();
		this.baseURL = baseURL;
	}
}
