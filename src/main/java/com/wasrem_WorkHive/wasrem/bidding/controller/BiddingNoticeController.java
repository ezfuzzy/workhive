package com.wasrem_WorkHive.wasrem.bidding.controller;


import com.wasrem_WorkHive.wasrem.bidding.service.BiddingNoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bidding-notices")
public class BiddingNoticeController {

    private final BiddingNoticeService biddingNoticeService;

    public BiddingNoticeController(BiddingNoticeService biddingNoticeService){
        this.biddingNoticeService = biddingNoticeService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getBiddingNoticeList() {
        return ResponseEntity.ok(Map.of("msg", "good"));
    }

}
