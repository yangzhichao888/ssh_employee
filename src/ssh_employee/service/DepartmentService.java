package ssh_employee.service;

import java.util.List;

import ssh_employee.domain.Department;
import ssh_employee.domain.PageBean;

/**
 * 部门管理的业务层接口
 * @author yzc
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
	
}
