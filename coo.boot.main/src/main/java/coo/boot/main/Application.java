package coo.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

@SpringBootApplication(scanBasePackages = {"coo.core", "coo.mvc", "coo.boot"})
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public FilterRegistrationBean registerOpenEntityManagerInViewFilterBean() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    OpenSessionInViewFilter filter = new OpenSessionInViewFilter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(5);
    return registrationBean;
  }
}
