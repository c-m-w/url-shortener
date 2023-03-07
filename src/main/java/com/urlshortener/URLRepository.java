package com.urlshortener;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface URLRepository
	extends CrudRepository<ShortenedURL, Long> {

	List<ShortenedURL> findAll();
	ShortenedURL findByShortenedURL(String shortenedURL);
	ShortenedURL saveAndFlush(ShortenedURL e);
}
