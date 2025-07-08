package com.wasrem_WorkHive.wasrem.common.mapper;


import com.wasrem_WorkHive.wasrem.bidding.dto.BiddingNoticeDto;
import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BiddingNoticeMapper {
    BiddingNotice toEntity(BiddingNoticeDto dto);
    BiddingNoticeDto toDto(BiddingNotice entity);
}
