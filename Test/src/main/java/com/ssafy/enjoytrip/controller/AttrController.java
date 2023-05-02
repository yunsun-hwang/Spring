package com.ssafy.enjoytrip.controller;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.gugun;
import com.ssafy.enjoytrip.model.service.AttrService;

@Controller
@RequestMapping("/attr")
public class AttrController{
	private AttrService attrService;
	public AttrController(AttrService attrService) {
		System.out.println("확인");
		this.attrService = attrService;
	}
	
	@GetMapping("search")
	public String search(@ModelAttribute Search search, Model model) throws Exception{
//		해당 관광지 보이기
		List<Attraction> list = attrService.search(search);
		model.addAttribute("attractions", list);
		
//		select에 시도 채우기
		model.addAttribute("sidos", attrService.sido());
		
//		검색창에 select 값들 유지하기
		model.addAttribute("sidos", attrService.sido());
		model.addAttribute("sido", search.getSido());	
		model.addAttribute("gugun", search.getGugun());				
		model.addAttribute("type", search.getType());				
		model.addAttribute("addr", search.getAddr());				
		return "search";
	}
	
	@GetMapping("detail")
	private String detail(String contentId, Model model) throws Exception{
		model.addAttribute("attraction", attrService.detail(contentId));
//		select에 시도 채우기
		model.addAttribute("sidos", attrService.sido());
		return "detail";
	}
	
	@GetMapping("gugun")
	public List<gugun> getGugun(@RequestParam("id") int code) {
		try {
			return attrService.getGugun(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
