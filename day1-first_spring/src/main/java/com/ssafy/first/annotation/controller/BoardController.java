package com.ssafy.first.annotation.controller;

import org.springframework.stereotype.Controller;

import com.ssafy.first.annotation.model.service.BoardService;


public class BoardController {
	private BoardService boardService;
	//	생성자가  하나일 경우 자동 주입됨.
	public BoardController(BoardService boardService) {
		System.out.println("BoardController(Service) 생성자 호출");
		this.boardService = boardService;
	}
	
	@Override
	public String toString() {
		return "BoardController [boardService=" + boardService + "]";
	}
}
