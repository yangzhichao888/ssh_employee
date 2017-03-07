package ssh_employee.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh_employee.domain.Department;
import ssh_employee.domain.Employee;
import ssh_employee.domain.PageBean;
import ssh_employee.service.DepartmentService;
import ssh_employee.service.EmployeeService;

/**
 * 员工管理的Action类
 * @author yzc
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	//模型驱动需要使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//注入业务层类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	

	
	/**
	 * 登陆执行的方法
	 */
	public String login(){
		System.out.println("login执行了");
		//接受数据，调用业务五层的类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登陆失败
			this.addActionError("用户名或密码错误!");
			return INPUT;
		}else{
			//登陆成功
			//把用户信息存入session中
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
	}
	
	//接收当前页数
	private Integer currPage = 1;

	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 分页查询员工的执行方法
	 * 
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加员工页面执行的方法
	 */
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * 保存员工的方法
	 * 
	 */ 	 
	 public String save(){
		 employeeService.save(employee);
		 return "saveSuccess";
	 }
	/**
	 * 编辑员工的执行方法
	 */
	 public String edit(){
		 //根据员工ID查询员工
		 employee = employeeService.findById(employee.getEid());
		 //查询所有部门
		 List<Department> list = departmentService.findAll();
		 ActionContext.getContext().getValueStack().set("list", list);
		 return "editSuccess";
	 }
	 /**
	  * 修改员工的执行的方法
	  * 
	  */
	 public String update(){
		 employeeService.update(employee);
		 return "updateSuccess";
	 }
	 /**
	  * 删除员工的方法
	  */
	 public String delete(){
		 employee = employeeService.findById(employee.getEid());
		 employeeService.delete(employee);
		 return "deleteSuccess";
	 }
}
