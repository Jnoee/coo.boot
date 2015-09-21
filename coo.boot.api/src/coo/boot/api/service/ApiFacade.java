package coo.boot.api.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import coo.base.exception.BusinessException;
import coo.boot.core.service.SecurityService;
import coo.mvc.util.ApiUtils;

@Service
public class ApiFacade {
	@Resource
	private SecurityService securityService;

	public void login(String username, String password) {
		try {
			securityService.signIn(username, password, "255.255.255.255");
		} catch (BusinessException e) {
			ApiUtils.thrown("100", e.getMessage());
		}
	}
}
