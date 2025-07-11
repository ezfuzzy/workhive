package com.wasrem_WorkHive.wasrem.bidding.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class G2BApiServiceImpl implements G2BApiService{




    @Override
    public void fetchAndSaveBiddingNotices() {

    }

    @Override
    public void fetchAndSaveBiddingNotices(LocalDateTime startDate, LocalDateTime endDate) {

    }

    @Override
    public boolean isApiHealthy() {
        return false;
    }
}
