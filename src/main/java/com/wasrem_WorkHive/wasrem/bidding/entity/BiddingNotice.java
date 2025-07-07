package com.wasrem_WorkHive.wasrem.bidding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class BiddingNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bidNtceNm;
    private String bidNtceNo;

    private String ntceInsttNm;
    private String rgstTyNm;
    private String cntrctCnclsMthdNm;
    private String pubPrcrmntClsfcNm;
    private String ntceInsttOfclNm;
    private String ntceInsttOfclTelNo;
    private String prtcptPsblRgnNm;
    private LocalDateTime bidNtceDt;
    private LocalDateTime bidBeginDt;
    private LocalDateTime bidClseDt;
    private String opengDt;
    private Long asignBdgtAmt;
    private Long presmptPrce;
    private String sucsfbidLwltRate;
    private String bidNtceDtlUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "bidding_notice_attachments", joinColumns = @JoinColumn(name = "notice_id"))
    private List<Attachment> attachments;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Attachment {
        private String ntceSpecFileNm;
        private String ntceSpecDocUrl;
    }
}