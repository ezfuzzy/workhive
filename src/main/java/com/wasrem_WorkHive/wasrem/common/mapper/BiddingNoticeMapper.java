package com.wasrem_WorkHive.wasrem.common.mapper;


import com.wasrem_WorkHive.wasrem.bidding.dto.BiddingNoticeDto;
import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BiddingNoticeMapper {
    BiddingNotice toEntity(BiddingNoticeDto dto);

    BiddingNoticeDto toDto(BiddingNotice entity);

    List<BiddingNotice> toEntityList(List<BiddingNoticeDto> dtos);

    List<BiddingNoticeDto> toDtoList(List<BiddingNotice> entities);

    // 첨부파일 변환 (내부 객체 직접 지정 필요 시)
    @Mapping(target = "attachments", source = "attachments")
    default List<BiddingNoticeDto.AttachmentDto> mapAttachments(List<BiddingNotice.Attachment> list) {
        if (list == null) return null;
        return list.stream()
                .map(a -> new BiddingNoticeDto.AttachmentDto(a.getNtceSpecFileNm(), a.getNtceSpecDocUrl()))
                .toList();
    }

    default List<BiddingNotice.Attachment> mapAttachmentsDto(List<BiddingNoticeDto.AttachmentDto> list) {
        if (list == null) return null;
        return list.stream()
                .map(a -> new BiddingNotice.Attachment(a.getNtceSpecFileNm(), a.getNtceSpecDocUrl()))
                .toList();
    }
}
