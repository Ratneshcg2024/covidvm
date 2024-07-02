package com.cg.covidvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.covidvm.entity.SlotBooking;

@Repository
public interface SlotBookingRepository extends JpaRepository<SlotBooking, Integer> {

	@Query("delete from SlotBooking s where s.empId =: eId")
	public void deleteSlot(@Param("eId") int empId);

}