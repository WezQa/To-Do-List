package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	@Query(value = "SELECT * FROM User", nativeQuery = true)
	public List<User> allFromUser();

	public Object findAllById(Long testId);

}