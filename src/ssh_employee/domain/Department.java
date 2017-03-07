package ssh_employee.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体
 * @author yzc
 *
 */
public class Department {

	private Integer did;
	private String dname;
	private String ddesc;
	private Set<Employee> employees = new HashSet<Employee>();
	//员工的集合
	public Integer getDid() {
		return did;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
}
