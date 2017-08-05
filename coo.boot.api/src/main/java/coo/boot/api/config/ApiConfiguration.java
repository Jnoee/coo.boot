package coo.boot.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import coo.mvc.api.ApiInterceptor;

@Configuration
public class ApiConfiguration extends WebMvcConfigurerAdapter {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/api/*/*");
  }
}
