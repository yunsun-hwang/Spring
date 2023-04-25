package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.Sido;
import com.ssafy.enjoytrip.dto.gugun;

@Repository
public class AttrDaoImpl implements AttrDao {
	private DataSource dataSource;
	public AttrDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Attraction> selectAttr(Search search) throws SQLException {
		String sql = "";
		if(search.getSido() != null && !search.getSido().equals("0")) sql += "and a.sido_code = " + search.getSido() + " ";
		if(search.getGugun() != null && !search.getGugun().equals("0")) sql += "and a.gugun_code = " + search.getGugun() + " ";
		if(search.getAddr() != null && !search.getAddr().equals("")) sql += "and addr1 like '%" + search.getAddr() + "%' ";
		if(search.getType() != null) sql += "and content_type_id = " + search.getType();
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select a.content_id, a.title, a.addr1, a.first_image, b.overview " + 
						"from attraction_info a, attraction_description b " + 
						"where a.content_id = b.content_id " + sql
				);
			) {
			ResultSet rs = pstmt.executeQuery();
			List<Attraction> list = new ArrayList<>();
			while (rs.next()) {
				Attraction a = new Attraction();
				a.setContentId(rs.getInt("a.content_id"));
				a.setTitle(rs.getString("a.title"));
				a.setAddr(rs.getString("a.addr1"));
				a.setImg(rs.getString("a.first_image"));
				a.setOverview(rs.getString("b.overview"));
				list.add(a);
			}		
			return list;
		}
	}
	
	@Override
	public Attraction selectAttrById(String contentId) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select a.content_id, a.title, a.addr1, a.first_image, b.overview " + 
						"from attraction_info a, attraction_description b " + 
						"where a.content_id = b.content_id and b.content_id = ? "
				);
			) {
			pstmt.setString(1, contentId);			
			ResultSet rs = pstmt.executeQuery();
			Attraction a = new Attraction();
			if (rs.next()) {
				a.setContentId(rs.getInt("a.content_id"));
				a.setTitle(rs.getString("a.title"));
				a.setAddr(rs.getString("a.addr1"));
				a.setImg(rs.getString("a.first_image"));
				a.setOverview(rs.getString("b.overview"));
			}		
			return a;
		}
	}
	@Override
	public List<Sido> selectSido() throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select sido_code, sido_name " + 
						"from enjoytrip.sido " + 
						"order by sido_code; "
				);
			) {
			ResultSet rs = pstmt.executeQuery();
			List<Sido> list = new ArrayList<>();
			while (rs.next()) {
				Sido s = new Sido();
				s.setCode(rs.getInt("sido_code"));
				s.setName(rs.getString("sido_name"));
				list.add(s);
			}		
			return list;
		}
	
	}
	@Override
	public List<gugun> selectGugun(int code) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select gugun_code, gugun_name " + 
						"from gugun " + 
						"where sido_code = ? ;"
				);
			) {
			pstmt.setInt(1, code);
			ResultSet rs = pstmt.executeQuery();
			List<gugun> list = new ArrayList<>();
			while (rs.next()) {
				gugun g = new gugun();
				g.setCode(rs.getInt("gugun_code"));
				g.setName(rs.getString("gugun_name"));
				list.add(g);
			}
			return list;
		}
	}


}
