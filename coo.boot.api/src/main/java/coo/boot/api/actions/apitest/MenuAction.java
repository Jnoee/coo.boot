package coo.boot.api.actions.apitest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import coo.mvc.security.annotations.Auth;
import coo.mvc.security.constants.AdminPermission;

/**
 * API 测试菜单。
 */
@Controller("apitest.menu")
@RequestMapping("/apitest")
@Auth(AdminPermission.CODE)
public class MenuAction {
  @RequestMapping("menu")
  public void menu() {}
}
