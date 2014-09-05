package coo.boot.demo.task;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import coo.base.util.DateUtils;
import coo.boot.demo.entity.Company;
import coo.boot.demo.service.CompanyService;

@Component
public class TestTask {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Resource
	private CompanyService companyService;

	@Transactional
	public void say() {
		Company company = new Company();
		company.setName("c" + DateUtils.format(new Date(), DateUtils.SECOND_N));
		company.setFoundDate(new Date());
		companyService.createCompany(company);
		log.debug("Auto create company[{}]", company.getName());
	}
}
