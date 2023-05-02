package com.ssafy.enjoytrip.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.Sido;
import com.ssafy.enjoytrip.dto.gugun;

@Mapper
public interface AttrMapper {
	List<Attraction> selectAttr(Search search) throws SQLException;
	Attraction selectAttrById(String contentId) throws SQLException;
	List<Sido> selectSido() throws SQLException;
	List<gugun> selectGugun(int code) throws SQLException;
}
