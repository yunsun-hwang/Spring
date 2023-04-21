package com.ssafy.exam.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.model.Board;

public interface BoardDao {

	List<Board> selectBoard() throws SQLException;

	void insertBoard(Board board) throws SQLException;


}
