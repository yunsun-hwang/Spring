package com.ssafy.enjoytrip.model.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.Sido;
import com.ssafy.enjoytrip.dto.gugun;
import com.ssafy.enjoytrip.model.dao.AttrDao;
import com.ssafy.enjoytrip.model.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrService {
	private AttrMapper attrMapper;
	
	public AttrServiceImpl(AttrMapper attrMapper) {
		this.attrMapper = attrMapper;
	}
	
	@Override
	public List<Attraction> search(Search search) throws Exception {
		return attrMapper.selectAttr(search);
	}

	@Override
	public Attraction detail(String contentId) throws Exception {
		return attrMapper.selectAttrById(contentId);
	}

	@Override
	public List<Sido> sido() throws Exception {
		return attrMapper.selectSido();
	}

	@Override
	public List<gugun> getGugun(int code) throws Exception {
		return attrMapper.selectGugun(code);
	}
}
