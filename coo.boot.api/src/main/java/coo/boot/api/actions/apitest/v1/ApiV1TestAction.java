package coo.boot.api.actions.apitest.v1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import coo.boot.api.model.LoginQuery;

/**
 * API 测试。
 */
@Controller
@RequestMapping("/apitest/v1")
public class ApiV1TestAction {
  /**
   * 登录。
   * 
   * @param model Model
   */
  @RequestMapping("login")
  public void login(Model model) {
    model.addAttribute(new LoginQuery());
  }
}
