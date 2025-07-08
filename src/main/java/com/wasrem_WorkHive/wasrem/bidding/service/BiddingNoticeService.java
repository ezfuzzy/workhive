package com.wasrem_WorkHive.wasrem.bidding.service;

import com.wasrem_WorkHive.wasrem.bidding.dto.BiddingNoticeDto;
import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;

public interface BiddingNoticeService {
    public BiddingNotice createBiddingNotice(BiddingNoticeDto request);
}
