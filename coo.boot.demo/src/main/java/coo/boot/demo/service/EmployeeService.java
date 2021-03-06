package coo.boot.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coo.base.model.Page;
import coo.base.util.BeanUtils;
import coo.boot.demo.entity.Employee;
import coo.core.hibernate.dao.Dao;
import coo.core.hibernate.search.FullTextCriteria;
import coo.core.model.SearchModel;
import coo.mvc.security.annotations.AutoFillIn;

/**
 * 职员管理。
 */
@Service
public class EmployeeService {
  @Resource
  private Dao<Employee> employeeDao;

  @Transactional(readOnly = true)
  public Page<Employee> search(SearchModel searchModel) {
    FullTextCriteria criteria = employeeDao.createFullTextCriteria();
    return employeeDao.searchPage(criteria, searchModel);
  }

  @Transactional(readOnly = true)
  public Employee get(String employeeId) {
    return employeeDao.get(employeeId);
  }

  @Transactional
  @AutoFillIn
  public void create(Employee employee) {
    employeeDao.save(employee);
  }

  @Transactional
  @AutoFillIn
  public void update(Employee employee) {
    Employee origEmployee = employeeDao.get(employee.getId());
    BeanUtils.copyFields(employee, origEmployee);
  }

  @Transactional
  public void delete(Employee employee) {
    employeeDao.remove(employee);
  }
}
