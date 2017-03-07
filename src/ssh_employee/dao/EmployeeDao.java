package ssh_employee.dao;

import java.util.List;

import ssh_employee.domain.Employee;

/**
 * 员工管理DAO层的接口
 * @author yzc
 *
 */
public interface EmployeeDao {

	Employee findByusernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

	
}
