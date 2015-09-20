package coo.boot.api.actions.api;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import coo.boot.api.model.LoginQuery;
import coo.boot.api.model.LoginReply;
import coo.mvc.actions.ApiAction;

@Controller
@RequestMapping("/api/v1")
public class ApiV1Action extends ApiAction {
	@RequestMapping("login")
	public LoginReply login(@Valid LoginQuery query) {
		return new LoginReply();
	}
}
