package com.abu.ws.error;

import org.springframework.boot.web.server.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorConfig implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/index.html");
		registry.addErrorPages(error404Page);
	}
}
