package com.ssafy.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sample.model.User;
import com.ssafy.sample.model.service.UserService;

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
//			header.jsp에서 userInfo로 정함.
			session.setAttribute("userInfo", userInfo);
		}
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
