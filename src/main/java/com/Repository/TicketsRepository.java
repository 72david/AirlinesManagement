package com.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Models.bookingentity;

@Repository
public interface TicketsRepository extends CrudRepository<bookingentity,Integer>{
	
	@Modifying
	@Query(value="Delete from Tickets t where t.pnrnumber=?1",nativeQuery=true)
	public void deleteById(int pnrnumber);
	
	@Modifying
	@Query(value="SELECT t.seatno from Tickets t where t.flightno=?1",nativeQuery=true)
	public ArrayList<Integer> findavailableseat(String flightno);
	
}
