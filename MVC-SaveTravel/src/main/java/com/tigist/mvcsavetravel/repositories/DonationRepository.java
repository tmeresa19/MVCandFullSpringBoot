package com.tigist.mvcsavetravel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tigist.mvcsavetravel.models.Donation;


@Repository
public interface DonationRepository extends CrudRepository<Donation, Long>{
	List<Donation> findAll();

}