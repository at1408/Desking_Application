package com.team17.desking.repository;

import com.team17.desking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.transaction.Transactional;

public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Query("select s from seat s where s.buildingId=?1")
    List<Seat> findByBuildingId(Long id);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update seat s set s.blocked = ?1 where s.seatId = ?2")
    void setSeatBlockStatus(Boolean blockStatus, Long seat_id);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update seat s set s.booked=1 where s.seatId = ?1")
    void setSeatBookStatus(Long seat_id);

}
