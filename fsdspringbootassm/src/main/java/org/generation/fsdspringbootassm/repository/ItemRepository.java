package org.generation.fsdspringbootassm.repository;

// This interface will extend from the CRUDRepository provided by Spring Boot Framework
// Then can access all the methods from the CRUDRepository object

import org.generation.fsdspringbootassm.repository.entity.Todolistdata;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Todolistdata, Integer> {

    // Nothing for now because we can just use the methods from the CrudRepository object
    // For more complex system, feature, there might be other methods that I need to add-on in the interface with the relevant class
}
