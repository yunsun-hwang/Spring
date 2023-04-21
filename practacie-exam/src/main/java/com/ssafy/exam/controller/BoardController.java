package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.exam.model.Board;
import com.ssafy.exam.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "list";
	}
//	@GetMapping("regist")
//	public String writeForm() throws Exception{
//		return "regist";
//	}
//	글쓰기 처리
//	@PostMapping("regist")
//	public String write(Board board) throws Exception{
//		boardService.write(board);
//		return "redirect:/list";
//	}
}
