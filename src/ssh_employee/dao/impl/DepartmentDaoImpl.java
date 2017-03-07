package ssh_employee.dao.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 部门管理的Dao实现类
 * @author yzc
 *
 */
import ssh_employee.dao.DepartmentDao;
import ssh_employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list= this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页查询部门
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	//DAO中保存部分的方法
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	//DAO中根据部门的ID查询部门的方法
	@Override
	public Department findById(Integer did) {
		return (Department) this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//Dao中修改部门的方法
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}

	@Override
	//Dao中删除部门的方法
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}

	@Override
	//查询所有部门的方法
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Department");
	}



}
