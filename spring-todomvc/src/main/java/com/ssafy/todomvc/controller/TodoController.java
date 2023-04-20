package com.ssafy.todomvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.todomvc.model.Todo;
import com.ssafy.todomvc.model.service.TodoService;

// WEB-INF/vies/todo/index.jsp
@Controller
@RequestMapping("/todo")
public class TodoController {
	private final TodoService todoService;
//	@Autowired 생성자가 하나 이기 때문에 쓰지 않는다.
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
//	@RequestMapping("/todo/list") 	// GET, POST 모두 가능
//	@RequestMapping(value = "/todo/list", method = RequestMethod.GET)	// GET 방식만 가능하게
	@GetMapping(value="list") //GET 방식만 가능하게
	public String listTodo(Model model) throws Exception{
		model.addAttribute("list", todoService.listTodo());
		//.xml servletContext prefix에 /WEB-INF/views/
		return "todo/index";
	}
	@PostMapping(value="regist")
	public String registTodo(Todo todo) throws Exception{
		System.out.println("Todo ->" + todo.getContent());
		todoService.registTodo(todo);
		return "redirect:list";
	}
	@GetMapping(value="clear")
	public String clearTodo(Todo todo) throws Exception{
		todoService.clearTodo();
		return "redirect:list";
	}
	@GetMapping(value="delete")
	public String deleteTodo(int no) throws Exception{
		todoService.deleteTodo(no);
		return "redirect:list";
	}
	
}