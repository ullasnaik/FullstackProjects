package com.stackroute.keepnote.netflixzuulapigatewayserver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * Implement zuul logging filter by extending zuul filter
 */
@Component
public class ZuulLoggingFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
}
