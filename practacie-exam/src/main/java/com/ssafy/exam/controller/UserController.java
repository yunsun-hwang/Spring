package com.ssafy.exam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.exam.model.User;
import com.ssafy.exam.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("login")
	public String login(User user, HttpSession session) throws Exception{
		User userInfo = userService.login(user);
		if(userInfo != null) {
			session.setAttribute("userInfo", userInfo);
		}
		else {
			session.setAttribute("msg", "id 또는 password를 확인하세요");
		}
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
