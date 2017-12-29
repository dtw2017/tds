package com.example.readinglist;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.readinglist.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByName(String name);
	
	long deleteByName(String name);
	List<User> removeByName(String name);
}
