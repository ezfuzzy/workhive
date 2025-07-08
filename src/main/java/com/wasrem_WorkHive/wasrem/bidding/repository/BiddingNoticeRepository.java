package com.wasrem_WorkHive.wasrem.bidding.repository;

import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiddingNoticeRepository extends JpaRepository<BiddingNotice, Long> {

}
