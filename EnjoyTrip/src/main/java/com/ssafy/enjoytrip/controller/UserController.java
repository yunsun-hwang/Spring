package com.ssafy.enjoytrip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.service.UserService;
import com.ssafy.enjoytrip.model.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController{
    private UserService uService;
    public UserController(UserService uService) {
		this.uService = uService;
	}
    @GetMapping("index")
    public String index() throws Exception{
    	return "index";
    }
//  login 페이지로 이동
    @GetMapping("signin")
    public String loginForm() throws Exception{
    	return "signin";
    }
//  signup 페이지로 이동
    @GetMapping("signup")
    public String signupForm() throws Exception{
    	return "signup";
    }
//  login 기능
    @PostMapping("login")
    public String login(User user, HttpSession session, Model model) throws Exception{
        User userInfo = uService.login(user);
        if(userInfo != null) {
            session.setAttribute("userInfo", userInfo);
        } 
        else {
        	model.addAttribute("signinMsg", "아이디 또는 비밀번호가 맞지 않습니다.");
        	return "signin";
        }
        return "index";
    }
//  logout 기능
    @GetMapping("logout")
    public String logout(HttpSession session) throws Exception{
    	session.invalidate();
    	return "redirect:/";
    }
//  password 찾기 페이지로 이동
    @GetMapping("findPw")
    public String findPwForm() throws Exception{
    	return "findPw";
    }
//  password 찾기
    @PostMapping("findPw")
    public String findPw(User user, Model model) throws Exception{
        User userInfo = uService.findPw(user);
        if(userInfo != null) {
        	System.out.println(userInfo.getPw());
            model.addAttribute("password", userInfo.getPw());
        }
        else {
        	model.addAttribute("noUser", "사용자 정보가 없습니다.");
        }
        return "findPw";
    }
//  signup 기능
    @PostMapping("signup")
	private String signup(User user, Model model) throws Exception{
		uService.signUpUser(user);
		
    	return "signin";
	}
    
    @GetMapping("myPageForm")
	private String mypageForm(User user, Model model) {
    	model.addAttribute("user", user);
    	return "mypage";
	}
//    @PostMapping("edit")
//	private String edit(User user, Model model) {
//		uService.editUser(user);
//		model.addAttribute("userInfo", user);
//    	return "redirect:/";
//	}
//    @GetMapping("delete")
//	private String delete(User user, String confirmbox, HttpSession session) {
//    	if(!confirmbox.equalsIgnoreCase("Confirm")) {
//    		return "redirect:/";
//    	}
//		uService.deleteUser(user);
//		session.invalidate();
//    	return "redirect:index";
//	}
}