package com.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Models.Airoplanedetails;

@Repository
public interface AiroplaneRepository extends CrudRepository<Airoplanedetails,Integer>{
	
	@Modifying
	@Query(value="SELECT * from Airoplane t where t.from=?1 and t.to=?2",nativeQuery = true)
	public ArrayList<Airoplanedetails> findbyfrom(String from,String to);
	
	@Modifying
	@Query(value="SELECT t.from from Airoplane t",nativeQuery = true)
	public ArrayList<String> findAllfrom();
	
	@Modifying
	@Query(value="SELECT t.to from Airoplane t",nativeQuery = true)
	public ArrayList<String> findAllto();
	
}
