package com.wasrem_WorkHive.wasrem.common.mapper;

import com.wasrem_WorkHive.wasrem.bidding.dto.BiddingNoticeDto;
import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BiddingNoticeMapper {

    BiddingNotice toEntity(BiddingNoticeDto dto);

    BiddingNoticeDto toDto(BiddingNotice entity);

    void updateEntityFromDto(BiddingNoticeDto dto, @MappingTarget BiddingNotice entity);

    @AfterMapping
    default void linkBiddingNotice(@MappingTarget BiddingNotice entity) {
        if (entity.getAgencyInfo() != null) {
            entity.getAgencyInfo().setBiddingNotice(entity);
        }
        if (entity.getApplicationCondition() != null) {
            entity.getApplicationCondition().setBiddingNotice(entity);
        }
        if (entity.getBudgetInfo() != null) {
            entity.getBudgetInfo().setBiddingNotice(entity);
        }
        if (entity.getCategoryInfo() != null) {
            entity.getCategoryInfo().setBiddingNotice(entity);
        }
        if (entity.getChangeHistory() != null) {
            entity.getChangeHistory().setBiddingNotice(entity);
        }
        if (entity.getCondition() != null) {
            entity.getCondition().setBiddingNotice(entity);
        }
        if (entity.getDocuments() != null) {
            entity.getDocuments().forEach(doc -> doc.setBiddingNotice(entity));
        }
        if (entity.getPersonInCharge() != null) {
            entity.getPersonInCharge().setBiddingNotice(entity);
        }
        if (entity.getBiddingResult() != null) {
            entity.getBiddingResult().setBiddingNotice(entity);
        }
        if (entity.getSchedule() != null) {
            entity.getSchedule().setBiddingNotice(entity);
        }
    }
}