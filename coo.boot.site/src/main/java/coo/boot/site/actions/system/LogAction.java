package coo.boot.site.actions.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coo.boot.core.entity.BnLog;
import coo.boot.core.service.BnLogger;
import coo.core.model.SearchModel;
import coo.mvc.security.annotations.Auth;
import coo.mvc.security.constants.AdminPermission;

/**
 * 日志管理。
 */
@Controller
@RequestMapping("/system")
@Auth(AdminPermission.CODE)
public class LogAction {
  @Resource
  private BnLogger bnLogger;

  /**
   * 查看日志列表。
   * 
   * @param model 数据模型
   * @param searchModel 搜索条件
   */
  @RequestMapping("log-list")
  public void list(Model model, SearchModel searchModel) {
    model.addAttribute("logPage", bnLogger.searchLog(searchModel));
  }

  /**
   * 查看日志详细记录。
   * 
   * @param model 数据模型
   * @param log 日志
   */
  @RequestMapping("log-view")
  public void view(Model model, @RequestParam("log") BnLog log) {
    model.addAttribute("log", log);
  }

  /**
   * 查看指定业务实体ID的日志详细记录列表。
   * 
   * @param model 数据模型
   * @param entityId 业务实体ID
   */
  @RequestMapping("log-detail-list")
  public void listDetail(Model model, String entityId) {
    model.addAttribute("entityLogs", bnLogger.searchEntityLog(entityId));
  }
}
