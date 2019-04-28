package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.domain.CustomerDetails;

@Repository
//public interface UserRepository extends JpaRepository<CustomerDetails,Integer>{

public interface UserRepository extends JpaRepository<CustomerDetails,Integer>{

//	@Query(value = "select * from customer where cif_number =?1",nativeQuery = true)
	CustomerDetails findByCifNumber(String cif);

}
