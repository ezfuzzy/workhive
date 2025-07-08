package com.wasrem_WorkHive.wasrem.bidding.controller;


import com.wasrem_WorkHive.wasrem.bidding.dto.BiddingNoticeDto;
import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;
import com.wasrem_WorkHive.wasrem.bidding.service.BiddingNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bidding-notices")
@Slf4j
public class BiddingNoticeController {

    private final BiddingNoticeService biddingNoticeService;

    public BiddingNoticeController(BiddingNoticeService biddingNoticeService){
        this.biddingNoticeService = biddingNoticeService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getBiddingNoticeList() {
        return ResponseEntity.ok(Map.of("msg", "good"));
    }

    @PostMapping
    public ResponseEntity<BiddingNotice> createBiddingNotice(
            @RequestBody BiddingNoticeDto request) {

        log.info("입찰공고 생성 요청 - 공고번호: {}", request.getBidNtceNo());

        try {
            BiddingNotice response = biddingNoticeService.createBiddingNotice(request);
            log.info("입찰공고 생성 성공 - ID: {}, 공고번호: {}",
                    response.getId(), response.getBidNtceNo());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {
            log.warn("입찰공고 생성 실패 - 잘못된 요청: {}", e.getMessage());
            return ResponseEntity.badRequest().build();

        } catch (DataIntegrityViolationException e) {
            log.warn("입찰공고 생성 실패 - 데이터 무결성 위반: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        } catch (Exception e) {
            log.error("입찰공고 생성 중 오류 발생 - 공고번호: {}", request.getBidNtceNo(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
