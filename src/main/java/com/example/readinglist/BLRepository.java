package com.example.readinglist;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BLRepository extends CrudRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {

}
