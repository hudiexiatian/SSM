package com.qm.smm.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qm.smm.entity.User;
import com.qm.smm.service.IUserService;

/**
 * 控制层
 * @author quanmin
 *
 */
@Controller
public class UserController{
	
	@Resource(name="userService")
	private IUserService userService;
	/**
	 * 更新
	 * @return
	 */
	@RequestMapping(value="/updateUser")
	public String updateUser(HttpServletRequest request,User user){
		userService.update(user.getId());
		return "redirect:/findUserList.do";
	}
	/**
	 * 删除
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/deleteUser")
	public String deleteUser(HttpServletRequest request,User user){
		userService.delete(user.getId());
		return "redirect:/findUserList.do";
	}
	/**
	 * 查找所有
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findUserList")
	public String findUserList(HttpServletRequest request){
		List<User> userList=userService.findUserList();
		request.setAttribute("userList", userList);
		return "list_user";
	}

	/**
	 * 跳转到添加用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddUser")
	public String toAddUser(HttpServletRequest request){
		return "/add";
	}
	/**
	 * 查找一个
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/findOne")
	public String findOne(HttpServletRequest request,User user){
		user=userService.selectUser(user.getId());
		request.setAttribute("u", user);
		return "/edit";
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,HttpServletResponse response,User user){
		User ul=userService.login(user.getName(),DigestUtils.md5Hex(user.getPwd()));
		//User ul=userService.login(user.getName(),user.getPwd());
		if(ul!=null){			
			return "redirect:index.jsp";
		}else{
			return "redirect:erro.jsp";
		}
	}
	/**
	 * 添加
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(HttpServletRequest request,User user){
		userService.add(user.getName(), DigestUtils.md5Hex(user.getPwd()));
		//userService.add(user.getName(), user.getPwd());
		return "redirect:/findUserList.do";
	}
	/**
	 * 跳转到登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String toLogin(HttpServletRequest request){
		return "/login";
	}
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}