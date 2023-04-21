package com.ssafy.exam.model.service;

import java.util.List;

import com.ssafy.exam.model.Board;

public interface BoardService {

	List<Board> list() throws Exception;

	void write(Board board) throws Exception;

}
