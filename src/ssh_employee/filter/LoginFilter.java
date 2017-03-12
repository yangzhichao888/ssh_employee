package ssh_employee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssh_employee.domain.Employee;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获得要用的对象：request,response,session
				HttpServletRequest servletRequest = (HttpServletRequest)request;
				HttpServletResponse servletResponse = (HttpServletResponse)response;
				HttpSession session = servletRequest.getSession();
				//获得用户请求的uri
				String path = servletRequest.getRequestURI();
				System.out.println(path);
				//从session中获取员工对象
				Employee existEmployee = (Employee)session.getAttribute("existEmployee");
				//登录页面无需过滤
				int checkPath = path.indexOf("login") + path.indexOf(".css") + path.indexOf(".js") + path.indexOf(".jpg")
					+ path.indexOf(".gif") + path.indexOf(".png");
				if (checkPath > 0) {
					System.out.println("登录页面不用过滤");
					chain.doFilter(servletRequest, servletResponse);
					return;
				}
				//如果没有获取到员工对象，跳转到登录页面
				if (null == existEmployee) {
					System.out.println("没有登录跳转");
					servletResponse.sendRedirect("index.jsp");
				} else {
					//获取到员工对象，继续此次请求
					System.out.println("已登录继续请求");
					chain.doFilter(servletRequest, servletResponse);
				}
		
	}

	@Override
	public void init(FilterConfig request) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
