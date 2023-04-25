package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.Sido;
import com.ssafy.enjoytrip.dto.gugun;

public interface AttrService {
	
	List<Attraction> search(Search search) throws Exception;

	Attraction detail(String contentId) throws Exception;

	List<Sido> sido() throws Exception;

	List<gugun> getGugun(int code) throws Exception;


}
