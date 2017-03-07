package ssh_employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh_employee.dao.DepartmentDao;
import ssh_employee.domain.Department;
import ssh_employee.domain.PageBean;
import ssh_employee.service.DepartmentService;
/**
 * 部门管理的业务层实现类
 * @author yzc
 *
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//再注入部门管理的Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	//分页查询部分的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数:
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数：
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	//业务层保存部门的方法
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	//业务层根据部门Id查询部门的方法
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	@Override
	//业务层修改部门的方法
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	//业务层删除部门的方法
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	@Override
	//查询所有部门的方法
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}

	
	
	
}
