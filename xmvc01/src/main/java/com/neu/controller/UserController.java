package com.neu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.pojo.User;
import com.neu.service.UserService;
/**
 * 用户管理Controller
 * @author Admin
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView  index(HttpServletRequest request)  {
		//代码编写处
		ModelAndView mav = new ModelAndView();
		if(request.getSession().getAttribute("user")==null) {
			mav.setViewName("/index");
		}else{
		List<User> list = userService.getUsers();
		mav.addObject("userList",list);
		mav.setViewName("/users");
		}
		return mav;
		
		
	}
}
