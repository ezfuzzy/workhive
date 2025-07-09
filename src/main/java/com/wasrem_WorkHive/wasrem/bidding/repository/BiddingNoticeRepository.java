package com.wasrem_WorkHive.wasrem.bidding.repository;

import com.wasrem_WorkHive.wasrem.bidding.entity.BiddingNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BiddingNoticeRepository extends JpaRepository<BiddingNotice, Long> {

    // 중복 체크용
    boolean existsByBidNtceNoAndBidNtceOrd(String bidNtceNo, String bidNtceOrd);

    // 상세 조회용 (상세 조회 시나리오에서 사용 - result 제외)
    @Query("""
        SELECT DISTINCT bn FROM BiddingNotice bn
        LEFT JOIN FETCH bn.agencyInfo ai
        LEFT JOIN FETCH bn.personInCharge pic
        LEFT JOIN FETCH bn.schedule s
        LEFT JOIN FETCH bn.documents d
        LEFT JOIN FETCH bn.condition c
        LEFT JOIN FETCH bn.budgetInfo bi
        LEFT JOIN FETCH bn.categoryInfo ci
        LEFT JOIN FETCH bn.applicationCondition ac
        LEFT JOIN FETCH bn.changeHistory ch
        WHERE bn.id = :id
    """)
    Optional<BiddingNotice> findByIdWithAllRelationsWithoutResult(@Param("id") Long id);

    // 상세 조회용 (상세 조회 시나리오에서 사용 - result 포함)
    @Query("""
        SELECT DISTINCT bn FROM BiddingNotice bn
        LEFT JOIN FETCH bn.agencyInfo ai
        LEFT JOIN FETCH bn.personInCharge pic
        LEFT JOIN FETCH bn.schedule s
        LEFT JOIN FETCH bn.documents d
        LEFT JOIN FETCH bn.condition c
        LEFT JOIN FETCH bn.budgetInfo bi
        LEFT JOIN FETCH bn.categoryInfo ci
        LEFT JOIN FETCH bn.applicationCondition ac
        LEFT JOIN FETCH bn.changeHistory ch
        LEFT JOIN FETCH bn.biddingResult r
        WHERE bn.id = :id
    """)
    Optional<BiddingNotice> findByIdWithAllRelationsWithResult(@Param("id") Long id);

    // 목록용 (목록 조회 시나리오에서 사용)
    @Query("""
        SELECT DISTINCT bn FROM BiddingNotice bn
        LEFT JOIN FETCH bn.agencyInfo ai
        LEFT JOIN FETCH bn.schedule s
        LEFT JOIN FETCH bn.budgetInfo bi
        LEFT JOIN FETCH bn.categoryInfo ci
        WHERE bn.id = :id
    """)
    Optional<BiddingNotice> findByIdForListView(@Param("id") Long id);

    // 낙찰 조회용 (낙찰 조회 시나리오에서 사용)
    @Query("""
        SELECT DISTINCT bn FROM BiddingNotice bn
        LEFT JOIN FETCH bn.agencyInfo ai
        LEFT JOIN FETCH bn.schedule s
        LEFT JOIN FETCH bn.budgetInfo bi
        LEFT JOIN FETCH bn.categoryInfo ci
        LEFT JOIN FETCH bn.biddingResult r
        WHERE bn.id = :id
    """)
    Optional<BiddingNotice> findByIdForResultView(@Param("id") Long id);

}
