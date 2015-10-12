package coo.boot.site.actions.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coo.boot.core.entity.User;
import coo.boot.core.service.SecurityService;
import coo.core.message.MessageSource;
import coo.core.model.SearchModel;
import coo.core.security.annotations.Auth;
import coo.core.security.permission.AdminPermission;
import coo.mvc.dwz.DialogResultUtils;
import coo.mvc.dwz.NavTabResultUtils;

/**
 * 用户管理。
 */
@Controller
@RequestMapping("/system")
@Auth(AdminPermission.CODE)
public class UserAction {
	@Resource
	private SecurityService securityService;
	@Resource
	private MessageSource messageSource;

	/**
	 * 查看用户列表。
	 * 
	 * @param model
	 *            数据模型
	 * @param searchModel
	 *            搜索条件
	 */
	@RequestMapping("user-list")
	public void list(Model model, SearchModel searchModel) {
		model.addAttribute("userPage", securityService.searchUser(searchModel));
	}

	/**
	 * 新增用户。
	 * 
	 * @param model
	 *            数据模型
	 */
	@RequestMapping("user-add")
	public void add(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("rootOrgan", securityService.getCurrentOrgan());
		model.addAttribute("roles", securityService.getAllRole());
	}

	/**
	 * 保存用户。
	 * 
	 * @param user
	 *            用户
	 * @return 返回提示信息。
	 */
	@RequestMapping("user-save")
	public ModelAndView save(User user) {
		securityService.createUser(user);
		return DialogResultUtils.closeAndReloadNavTab(messageSource
				.get("user.add.success"));
	}

	/**
	 * 编辑用户。
	 * 
	 * @param model
	 *            数据模型
	 * @param user
	 *            用户
	 */
	@RequestMapping("user-edit")
	public void edit(Model model, User user) {
		model.addAttribute(user);
	}

	/**
	 * 更新用户。
	 * 
	 * @param user
	 *            用户
	 * @return 返回提示信息。
	 */
	@RequestMapping("user-update")
	public ModelAndView update(User user) {
		securityService.updateUser(user);
		return DialogResultUtils.closeAndReloadNavTab(messageSource
				.get("user.edit.success"));
	}

	/**
	 * 禁用用户。
	 * 
	 * @param user
	 *            用户
	 * @return 返回提示信息。
	 */
	@RequestMapping("user-disable")
	public ModelAndView disable(User user) {
		securityService.disableUser(user);
		return NavTabResultUtils.reload(messageSource
				.get("user.disable.success"));
	}

	/**
	 * 启用用户。
	 * 
	 * @param user
	 *            用户
	 * @return 返回提示信息。
	 */
	@RequestMapping("user-enable")
	public ModelAndView enable(User user) {
		securityService.enableUser(user);
		return NavTabResultUtils.reload(messageSource
				.get("user.enable.success"));
	}

	/**
	 * 重置用户密码。
	 * 
	 * @param model
	 *            数据模型
	 * @param user
	 *            用户
	 */
	@RequestMapping("user-pwd-reset")
	public void pwdReset(Model model, User user) {
		model.addAttribute("defaultPassword", AdminPermission.DEFAULT_PASSWORD);
	}

	/**
	 * 保存重置密码。
	 * 
	 * @param managePassword
	 *            管理员密码
	 * @param user
	 *            用户
	 * @return 返回提示信息。
	 */
	@RequestMapping("user-pwd-reset-save")
	public ModelAndView pwdResetSave(String managePassword, User user) {
		securityService.resetPassword(managePassword, user);
		return DialogResultUtils.close(messageSource
				.get("user.pwd.reset.success"));
	}
}