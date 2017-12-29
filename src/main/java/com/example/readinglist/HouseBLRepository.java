package com.example.readinglist;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface HouseBLRepository extends CrudRepository<HouseBL, Integer>{
	HouseBL findByhblno(String hblno);
}
