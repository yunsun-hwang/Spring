package com.ssafy.enjoytrip.controller;

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController{
    private UserService uService;
	private final Logger logger = Logger.getLogger(UserController.class.getName());
    public UserController(UserService uService) {
		this.uService = uService;
	}
    
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) throws Exception {
    	User userInfo = uService.login(user);
    	if (userInfo != null) {
    		session.setAttribute("userInfo", userInfo);
    		return ResponseEntity.ok("success");
    	} else {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failure");
    	}
    }
    
    @GetMapping("logout")
    public ResponseEntity<String> logout(HttpSession session) throws Exception{
    	session.invalidate();
    	return ResponseEntity.ok("success");
    }
    
    @PostMapping("findPw")
    public ResponseEntity<String> findPw(@RequestBody User user) throws Exception {
    	User userInfo = uService.findPw(user);
    	if (userInfo != null) {
    		return new ResponseEntity<>(userInfo.getPw(), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    @GetMapping("getUser/{userid}")
    public ResponseEntity<?> userInfo(@PathVariable("userid") String userId) throws Exception {
    	User userInfo = uService.getUser(userId);
    	if(userInfo != null) {
    		return new ResponseEntity<User>(userInfo, HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    @GetMapping("idcheck")
    public ResponseEntity<String> idcheck(@RequestBody User user) throws Exception{
        User userInfo = uService.idCheck(user.getId());
        if (userInfo == null) {
            // 아이디가 이미 존재하는 경우
            return ResponseEntity.ok("available");
        } else {
            // 아이디가 사용 가능한 경우
            return ResponseEntity.ok("unavailable");
        }
    }
    
    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        try {
            uService.signUpUser(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            uService.editUser(user);
            return new ResponseEntity<>("회원 정보가 수정되었습니다.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("회원 정보 수정에 실패하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(HttpSession session) throws Exception {
        User userInfo = (User) session.getAttribute("userInfo");
        uService.deleteUser(userInfo);
        session.invalidate();
        return ResponseEntity.noContent().build();
    }
//    @GetMapping("index")
//    public String index() throws Exception{
//    	return "index";
//    }
    
//  login 페이지로 이동
//    @GetMapping("signin")
//    public String loginForm() throws Exception{
//    	return "signin";
//    }
    
//  signup 페이지로 이동
//    @GetMapping("signup")
//    public String signupForm() throws Exception{
//    	return "signup";
//    }
    
//  login 기능
//    @PostMapping("login")
//    public String login(User user, HttpSession session, Model model) throws Exception{
//        User userInfo = uService.login(user);
//        if(userInfo != null) {
//            session.setAttribute("userInfo", userInfo);
//        } 
//        else {
//        	model.addAttribute("signinMsg", "아이디 또는 비밀번호가 맞지 않습니다.");
//        	return "signin";
//        }
//        return "index";
//    }

//  logout 기능
//    @GetMapping("logout")
//    public String logout(HttpSession session) throws Exception{
//    	session.invalidate();
//    	return "redirect:/";
//    }
    
    
//  password 찾기 페이지로 이동
//    @GetMapping("findPw")
//    public String findPwForm() throws Exception{
//    	return "findPw";
//    }
    
//  pw 찾기 기능
//    @ResponseBody
//    @PostMapping("findPw")
//    public String findPw(User user) throws Exception{
//        User userInfo = uService.findPw(user);
//        if(userInfo != null) {
//        	return userInfo.getPw();
//        }
//        else {
//        	return null;
//        }
//    }
    
//  mypage로 이동
//    @GetMapping("mypageForm")
//	private String mypageForm() {
//    	return "mypage";
//	}
    
//  아이디 존재여부 확인
//    @ResponseBody
//    @GetMapping("idcheck")
//    private String idcheck(User user) throws Exception{    	
//    	User userInfo = uService.idCheck(user.getId());
//    	if (userInfo == null) {
//	        // 아이디가 이미 존재하는 경우
//    		return "available";
//	    } else {
//	        // 아이디가 사용 가능한 경우
//	        return "unavailable";
//	    }
//    }

    
//  signup 기능
//    @PostMapping("signup")
//	private String signup(User user, Model model) throws Exception{
//		uService.signUpUser(user);
//    	return "signin";
//	}

    
//  사용자 삭제
//    @PostMapping("delete")
//	private String delete(HttpSession session) throws Exception{
//    	User userInfo = (User) session.getAttribute("userInfo");
//		uService.deleteUser(userInfo);
//		session.invalidate();
//    	return "index";
//	}

}