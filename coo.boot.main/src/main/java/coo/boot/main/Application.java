package coo.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 组件配置。
 */
@SpringBootApplication(scanBasePackages = {"coo.core", "coo.mvc", "coo.boot"})
public class Application {
  /**
   * 主方法。
   * 
   * @param args 参数
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /**
   * 配置OSIV Filter。
   * 
   * @return 返回OSIV Filter。
   */
  @Bean
  public FilterRegistrationBean openSessionInViewFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(new OpenSessionInViewFilter());
    registrationBean.setOrder(5);
    return registrationBean;
  }

  /**
   * 配置Druid StatViewServlet。
   * 
   * @return 返回StatViewServlet。
   */
  @Bean
  public ServletRegistrationBean druidStatView() {
    return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
  }

  /**
   * 配置Druid WebStatFilter。
   * 
   * @return 返回WebStatFilter。
   */
  @Bean
  public FilterRegistrationBean druidWebStatFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.addUrlPatterns("/*");
    registrationBean.addInitParameter("exclusions",
        "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.htm,/druid/*");
    registrationBean.addInitParameter("sessionStatEnable", "false");
    registrationBean.addInitParameter("profileEnable", "true");
    registrationBean.setFilter(new WebStatFilter());
    return registrationBean;
  }
}
