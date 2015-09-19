package coo.boot.demo.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import coo.boot.demo.entity.Company;

@Component("coo.boot.demo.service.TaskScheduler")
@Lazy(false)
public class TaskScheduler {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource
	private CompanyService companyService;

	// @Scheduled(initialDelay = 1000 * 10, fixedDelay = 1000 * 10)
	public void autoCreateCompany() {
		Company company = companyService.autoCreateCompany();
		log.debug("Auto create company[{}]", company.getName());
	}
}
