package ssh_employee.service;

import ssh_employee.domain.Employee;
import ssh_employee.domain.PageBean;

/**
 * 员工管理业务层接口
 * @author yzc
 *
 */

public interface EmployeeService {

	Employee login(Employee employee);

	

	PageBean<Employee> findByPage(Integer currPage);



	void save(Employee employee);



	Employee findById(Integer eid);



	void update(Employee employee);



	void delete(Employee employee);

}
