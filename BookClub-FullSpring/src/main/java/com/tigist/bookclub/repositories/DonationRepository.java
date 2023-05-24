package com.tigist.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tigist.bookclub.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
	List<Donation> findAll();
}
