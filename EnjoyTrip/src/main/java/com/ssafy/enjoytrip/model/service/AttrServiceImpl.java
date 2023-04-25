package com.ssafy.enjoytrip.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.Sido;
import com.ssafy.enjoytrip.dto.gugun;
import com.ssafy.enjoytrip.model.dao.AttrDao;
import com.ssafy.enjoytrip.model.dao.AttrDaoImpl;

@Service
public class AttrServiceImpl implements AttrService {
	private AttrDao attrDao;
	public AttrServiceImpl(AttrDao attrDao) {
		this.attrDao = attrDao;
	}
	
	@Override
	public List<Attraction> search(Search search) throws Exception {
		return attrDao.selectAttr(search);
	}

	@Override
	public Attraction detail(String contentId) throws Exception {
		return attrDao.selectAttrById(contentId);
	}

	@Override
	public List<Sido> sido() throws Exception {
		return attrDao.selectSido();
	}

	@Override
	public List<gugun> getGugun(int code) throws Exception {
		return attrDao.selectGugun(code);
	}


}
