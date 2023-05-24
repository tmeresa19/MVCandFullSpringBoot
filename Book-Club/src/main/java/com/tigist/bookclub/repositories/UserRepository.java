package com.tigist.bookclub.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tigist.bookclub.models.User;


public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email) ;

}
