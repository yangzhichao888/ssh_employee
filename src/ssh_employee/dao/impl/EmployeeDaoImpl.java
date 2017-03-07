package ssh_employee.dao.impl;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ssh_employee.dao.EmployeeDao;
import ssh_employee.domain.Employee;
/**
 * 员工管理DAO的实现类
 * @author yzc
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	
	public Employee findByusernameAndPassword(Employee employee){
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, new String[]{employee.getUsername(),employee.getPassword()});
		
		
		if(list.size() > 0)	//查到了数据
			return list.get(0); //返回查到的数据
		return null;
		
	}

	@Override
	//统计个数的方法
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	//分页查询
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list  = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list; 
	}

	@Override
	//Dao中保存员工的方法
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	//DAO中根据员工ID查询员工
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return (Employee) this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
}
