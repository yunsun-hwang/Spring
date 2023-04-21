package com.ssafy.exam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.exam.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao{
	private DataSource dataSource;
	
	public BoardDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Board> selectBoard() throws SQLException {
		List<Board> list = new ArrayList<Board>();
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select code, model, price "
						+ "from product "
						+ "order by code desc "
			);
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setCode(rs.getString("code"));
				b.setModel(rs.getString("model"));
				b.setPrice(rs.getInt("price"));
				list.add(b);
			}
		}
		return list;
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into product(code, model, price) values(?, ?, ?)"
			);
		){
			pstmt.setString(1,board.getCode());
			pstmt.setString(2, board.getModel());
			pstmt.setInt(3, board.getPrice());
			pstmt.executeUpdate();			
		}
		
	}

}
