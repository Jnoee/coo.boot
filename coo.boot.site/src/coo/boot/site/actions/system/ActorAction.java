package coo.boot.site.actions.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coo.boot.core.entity.Actor;
import coo.boot.core.entity.User;
import coo.boot.core.service.SecurityService;
import coo.core.message.MessageSource;
import coo.core.security.annotations.Auth;
import coo.core.security.permission.AdminPermission;
import coo.mvc.util.DialogResultUtils;

/**
 * 职务管理。
 */
@Controller
@RequestMapping("/system")
@Auth(AdminPermission.CODE)
public class ActorAction {
	@Resource
	private SecurityService securityService;
	@Resource
	private MessageSource messageSource;

	/**
	 * 新增职务。
	 * 
	 * @param model
	 *            数据模型
	 * @param user
	 *            关联用户
	 */
	@RequestMapping("actor-add")
	public void add(Model model, User user) {
		Actor actor = new Actor();
		actor.setUser(user);
		model.addAttribute(actor);
		model.addAttribute("rootOrgan", securityService.getCurrentOrgan());
		model.addAttribute("roles", securityService.getAllRole());
	}

	/**
	 * 保存职务。
	 * 
	 * @param actor
	 *            职务
	 * @return 返回提示信息。
	 */
	@RequestMapping("actor-save")
	public ModelAndView save(Actor actor) {
		securityService.createActor(actor);
		return DialogResultUtils.closeAndReloadDialog(
				messageSource.get("actor.add.success"), "user-edit");
	}

	/**
	 * 编辑职务。
	 * 
	 * @param model
	 *            数据模型
	 * @param actor
	 *            职务
	 */
	@RequestMapping("actor-edit")
	public void edit(Model model, Actor actor) {
		model.addAttribute("rootOrgan", securityService.getCurrentUser()
				.getSettings().getDefaultActor().getOrgan());
		model.addAttribute("roles", securityService.getAllRole());
	}

	/**
	 * 更新职务。
	 * 
	 * @param actor
	 *            职务
	 * @return 返回提示信息。
	 */
	@RequestMapping("actor-update")
	public ModelAndView update(Actor actor) {
		securityService.updateActor(actor);
		return DialogResultUtils.closeAndReloadDialog(
				messageSource.get("actor.edit.success"), "user-edit");
	}

	/**
	 * 删除职务。
	 * 
	 * @param actor
	 *            职务
	 * @return 返回提示信息。
	 */
	@RequestMapping("actor-delete")
	public ModelAndView delete(Actor actor) {
		securityService.deleteActor(actor);
		return DialogResultUtils.reload(messageSource
				.get("actor.delete.success"));
	}
}