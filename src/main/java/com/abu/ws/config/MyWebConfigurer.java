package com.abu.ws.config;

import com.abu.ws.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

	@Bean
	public LoginInterceptor getLoginIntercepter() {
		return new LoginInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**")
				.excludePathPatterns("/index.html");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//所有请求都允许跨域
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/api/file/**")
				.addResourceLocations("file:" + "C:/Users/AbuYoung/Desktop/workspace/img/");
	}
}
