package com.ssafy.enjoytrip.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.Sido;
import com.ssafy.enjoytrip.dto.gugun;

public interface AttrDao {

	List<Attraction> selectAttr(Search search) throws SQLException;

	Attraction selectAttrById(String contentId) throws SQLException;

	List<Sido> selectSido() throws SQLException;

	List<gugun> selectGugun(int code) throws SQLException;

}
