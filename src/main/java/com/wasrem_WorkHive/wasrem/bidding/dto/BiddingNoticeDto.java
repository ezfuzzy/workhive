package com.wasrem_WorkHive.wasrem.bidding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BiddingNoticeDto {
    private Long id;

    private String bidNtceNm;           //      공고명
    private String ntceInsttNm;         //      공고기관명

    private String rgstTyNm;            //      발주처
    private String cntrctCnclsMthdNm;   //      계약방법
    private String pubPrcrmntClsfcNm;   //      제공받을 서비스 분류
    private String ntceInsttOfclNm;     //      담당자
    private String ntceInsttOfclTelNo;  //      담당자 번호
    private String prtcptPsblRgnNm;     //      참가 가능 지역
    private String bidNtceNo;           //      공고번호
    private LocalDateTime bidNtceDt;    //      공고일
    private LocalDateTime bidBeginDt;   //      입찰 시작일
    private LocalDateTime bidClseDt;    //      입찰 마감일 ( 보통 개찰일과 같음. 개찰 시간보다 1시간 빠름 )
    private String opengDt;             //      개찰
    private Long asignBdgtAmt;          //      기초금액
    private Long presmptPrce;           //      추정가격
    private String sucsfbidLwltRate;    //      낙찰하한율
    private String bidNtceDtlUrl;       //      나라장터 상세보기 사이트 링크

    // 첨부파일 목록 (최대 10개, 일부만 존재할 수 있음)
    private List<AttachmentDto> attachments;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AttachmentDto {
        private String ntceSpecFileNm;
        private String ntceSpecDocUrl;
    }
}
