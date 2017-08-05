package coo.boot.main.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import coo.boot.core.service.SecurityService;

/**
 * 主页。
 */
@Controller
@RequestMapping("/")
public class IndexAction {
  @Resource
  private SecurityService securityService;

  /**
   * 查看主页。
   * 
   * @param model 数据模型
   */
  @RequestMapping("index")
  public void index(Model model) {
    model.addAttribute("currentUser", securityService.getCurrentUser());
  }
}
