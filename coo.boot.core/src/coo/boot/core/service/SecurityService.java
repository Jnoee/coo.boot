package coo.boot.core.service;

import org.springframework.stereotype.Service;

import coo.boot.core.entity.Actor;
import coo.boot.core.entity.Organ;
import coo.boot.core.entity.Role;
import coo.boot.core.entity.User;
import coo.core.security.service.AbstractSecurityService;

/**
 * 安全服务。
 */
@Service
public class SecurityService extends
		AbstractSecurityService<Organ, User, Role, Actor> {
}