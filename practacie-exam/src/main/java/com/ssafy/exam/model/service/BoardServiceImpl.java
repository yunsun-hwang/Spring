package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.Board;
import com.ssafy.exam.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	private BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectBoard();
	}
	
	@Override
	public void write(Board board) throws Exception {
		boardDao.insertBoard(board);
	}
	

}
