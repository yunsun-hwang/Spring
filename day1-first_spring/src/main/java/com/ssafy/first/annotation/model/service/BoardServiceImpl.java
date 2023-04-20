package com.ssafy.first.annotation.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.first.xml.model.dao.BoardDao;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl() 객체 생성");
	}
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
}
