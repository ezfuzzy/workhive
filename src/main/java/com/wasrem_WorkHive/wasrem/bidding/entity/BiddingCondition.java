package com.wasrem_WorkHive.wasrem.bidding.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class BiddingCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bidding_notice_id", unique = true)
    private BiddingNotice biddingNotice;

    private String cmmnSpldmdAgrmntRcptdocMethd; // 협정서 접수 방식
    private LocalDateTime cmmnSpldmdAgrmntClseDt; // 공동수급협정마감일시
    private Boolean cmmnSpldmdCorpRgnLmtYn;       // 공동수급업체지역제한여부
    private Boolean rbidPermsnYn;                 // 재입찰허용여부

    private Boolean bidPrtcptLmtYn;               // 입찰참가제한여부
    private Boolean indstrytyLmtYn;               // 업종제한여부
    private Boolean dtlsBidYn;                    // 내역입찰여부
    private Boolean bidGrntymnyPaymntYn;          // 입찰보증금납부여부
    private Boolean bidPrtcptFeePaymntYn;         // 입찰참가수수료납부여부
    private Boolean brffcBidprcPermsnYn;          // 지사투찰허용여부
    private Boolean dsgntCmptYn;                  // 지명경쟁여부
    private Boolean arsltCmptYn;                  // 실적경쟁여부
    private Boolean pqEvalYn;                     // PQ심사여부
    private Boolean tpEvalYn;                     // TP심사여부
    private Boolean ntceDscrptYn;                 // 공고설명여부
}
