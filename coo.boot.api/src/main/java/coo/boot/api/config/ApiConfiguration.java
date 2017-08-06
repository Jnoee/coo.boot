package coo.boot.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import coo.mvc.api.ApiInterceptor;

/**
 * 组件配置。
 */
@Configuration
public class ApiConfiguration extends WebMvcConfigurerAdapter {
  /**
   * 配置API拦截器。
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/api/*/*");
  }
}
