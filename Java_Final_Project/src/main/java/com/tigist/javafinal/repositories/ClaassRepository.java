// This is a Java code defining a repository interface `ClaassRepository` that extends the
// `CrudRepository` interface. It is used to perform CRUD (Create, Read, Update, Delete) operations on
// the `Claass` entity. The `@Repository` annotation indicates that this interface is a Spring Data
// repository. The `findAll()` method is used to retrieve all instances of the `Claass` entity.
package com.tigist.javafinal.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tigist.javafinal.models.Claass;


@Repository
public interface ClaassRepository extends CrudRepository<Claass, Long> {
	List<Claass> findAll();
}
