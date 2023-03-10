package com.urlshortener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class TemplateEngine {

	 @Bean
	 public SpringTemplateEngine GetTemplateEngine() {
		 
		 ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		 
		 resolver.setPrefix("templates/");
		 resolver.setSuffix(".html");
		 resolver.setTemplateMode("HTML5");
		 resolver.setOrder(1);
		 resolver.setCacheable(true);
		 templateEngine.addTemplateResolver(resolver);
		 
		 return templateEngine;
	 }
}
