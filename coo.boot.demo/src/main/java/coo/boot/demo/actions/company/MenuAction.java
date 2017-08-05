package coo.boot.demo.actions.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import coo.mvc.security.annotations.Auth;

/**
 * 公司管理菜单。
 */
@Controller("company.menu")
@RequestMapping("/company")
@Auth({"COMPANY_MANAGE", "EMPLOYEE_MANAGE"})
public class MenuAction {
  @RequestMapping("menu")
  public void menu() {}
}
