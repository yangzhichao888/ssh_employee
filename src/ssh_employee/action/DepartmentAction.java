package ssh_employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh_employee.domain.Department;
import ssh_employee.domain.PageBean;
import ssh_employee.service.DepartmentService;

/**
 * 部门管理Action的类
 * @author yzc
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//迷行驱动使用的对象
	private Department department = new Department();
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

	private Integer currPage = 1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//注入部门管理的Service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//提供查询的方法
	public String findAll(){
		PageBean<Department> pageBean= departmentService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//跳转到添加部门的页面方法
	public String saveUI(){
		return "saveUI";
	}
	//添加部门的方法
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门的执行方法
	public String edit(){
		department  = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	//修改部门的执行方法
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//删除部门的执行方法：
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
