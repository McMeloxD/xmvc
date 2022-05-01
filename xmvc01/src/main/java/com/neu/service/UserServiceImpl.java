package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.UserMapper;
import com.neu.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String userName) {
		return userMapper.findUserByName(userName);
	}

	/**
	 * 登录验证方法的实现
	 */
	public boolean isLogin(User user) {
		//代码编写处
		//从传入的user对象获得name和password属性
		//根据用户名实例化一个user对象
		User user1 = userMapper.findUserByName(user.getUserName());
		//若能根据用户名查询到用户信息则进行密码对比
		if(user1 != null) {
			//判断密码是否正确			
			if(user.getPassword().equals(user1.getPassword())) {
				return true;
			}else {
				//密码错误返回false
				return false;
			}
			//找不到用户名,登录失败，返回false
		}else {
			return false;
		}
		
	}

	public List<User> getUsers() {
		
		return userMapper.findAll();
	}

}
