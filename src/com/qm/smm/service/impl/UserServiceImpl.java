package com.qm.smm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.qm.smm.entity.User;
import com.qm.smm.mapper.UserMapper;
import com.qm.smm.service.IUserService;

/**
 * 服务层接口实现
 * @author quanmin
 *
 */
@Repository(value="userService")
public class UserServiceImpl implements IUserService{
	
	
	@Resource(name="userMapper")
	private UserMapper userMapper;

	@Override
	public List<User> findUserList() {
		return userMapper.findUserList();
	}
	@Override
	public User login(String name, String pwd) {
		return userMapper.login(name, pwd);
	}
	
	@Override
	public void add(String name, String pwd) {
		userMapper.add(name, pwd);
	}
	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}
	@Override
	public User selectUser(int id) {
		User user=userMapper.selectUser(id);
		return user;
	}
	
	@Override
	public void update(int id) {
		userMapper.update(id);
	}

}
