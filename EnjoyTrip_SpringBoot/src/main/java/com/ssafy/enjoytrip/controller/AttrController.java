package com.ssafy.enjoytrip.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.dto.Attraction;
import com.ssafy.enjoytrip.dto.Search;
import com.ssafy.enjoytrip.dto.gugun;
import com.ssafy.enjoytrip.model.service.AttrService;

@RestController
@RequestMapping("/attr")
public class AttrController {
    private final Logger logger = Logger.getLogger(AttrController.class.getName());

    private AttrService attrService;

    public AttrController(AttrService attrService) {
        this.attrService = attrService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<Attraction>> search(@RequestBody Search search) {
        try {
            List<Attraction> list = attrService.search(search);
            logger.info(list.toString());
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @GetMapping("/detail/{contentId}")
    public ResponseEntity<Attraction> detail(@PathVariable String contentId) {
        try {
            Attraction attraction = attrService.detail(contentId);
            return ResponseEntity.ok().body(attraction);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/gugun")
    public ResponseEntity<List<gugun>> getGugun(@RequestParam int id) {
        try {
            List<gugun> gugunList = attrService.getGugun(id);
            return ResponseEntity.ok().body(gugunList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
