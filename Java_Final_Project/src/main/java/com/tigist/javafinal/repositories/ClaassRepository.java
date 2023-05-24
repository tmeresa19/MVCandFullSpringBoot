package com.tigist.javafinal.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tigist.javafinal.models.Claass;


@Repository
public interface ClaassRepository extends CrudRepository<Claass, Long> {
	List<Claass> findAll();
}
