package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Models.*;

@Repository
public interface UserDataRepository extends CrudRepository<userdetails,String> {
	
}
