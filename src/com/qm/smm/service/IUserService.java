package com.qm.smm.service;

import java.util.List;

import com.qm.smm.entity.User;

/**
 * 服务层接口
 * @author quanmin
 */
public interface IUserService {
	/**
	 * 查找所有用户
	 * @return
	 */
	public List<User> findUserList();
	/**
	 * 添加
	 * @param name
	 * @param pwd
	 */
	public void add(String name,String pwd);
	/**
	 * 验证登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name,String pwd);
	/**
	 * 更新
	 * @param id
	 */
	public void update(int id);
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public User selectUser(int id);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id);
}
