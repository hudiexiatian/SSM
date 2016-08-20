package com.qm.smm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.qm.smm.entity.User;

/**
 * 用户映射
 * @author quanmin
 *
 */
@Repository(value="userMapper")
public interface UserMapper {
	
	@Select("select * from user where id = #{0}")
	public User selectUser(int id);
	
	@Select("select id,name,pwd from user")
	public List<User> findUserList();
	
	@Insert("insert into user(name,pwd) values(#{0},#{1})")
	public void add(String name,String pwd);
	
	@Select("select * from user where name = #{0} and pwd = #{1}")
	public User login(String name,String pwd);
	
	@Update("update user set pwd=#{1} where id=#{0}")
	public void update(int id);
	
	@Delete("delete from user where id=#{0}")
	public void delete(int id);
}
