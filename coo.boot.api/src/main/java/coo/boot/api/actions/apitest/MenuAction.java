package coo.boot.api.actions.apitest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import coo.mvc.security.annotations.Auth;
import coo.mvc.security.constants.AdminPermission;

@Controller("apitest.menu")
@RequestMapping("/apitest")
@Auth(AdminPermission.CODE)
public class MenuAction {
  @RequestMapping("menu")
  public void menu() {}
}
