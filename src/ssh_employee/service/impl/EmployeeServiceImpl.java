package ssh_employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh_employee.dao.EmployeeDao;
import ssh_employee.domain.Employee;
import ssh_employee.domain.PageBean;
import ssh_employee.service.EmployeeService;

@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * 业务层的登陆方法
	 */
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByusernameAndPassword(employee);
		return existEmployee;
	}

	
	@Override
	/**
	 * 业务层的分页查询员工的方法
	 */
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		
		System.out.println("总页数："+num);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//业务层保存员工的方法
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}

	@Override
	//根据员工ID查询员工的方法
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}

	@Override
	//业务层修改员工的方法
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	//业务层删除员工的方法
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
