package cn.ncu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.ncu.entity.User;
import cn.ncu.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.action")
	public String login(HttpServletRequest request,User user) throws Exception {	
		System.out.println("login ============ " );
		//调用service方法，进行用户匹配	
		System.out.println(user);
		User temp = userService.Login(user);
		if(null != temp){//登录成功
			//放入session
			request.getSession().setAttribute("user", temp);
			//页面跳转（frame.jsp）
			System.out.println(temp);
			return "success.jsp";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "index.jsp";
		}
	}	
}
