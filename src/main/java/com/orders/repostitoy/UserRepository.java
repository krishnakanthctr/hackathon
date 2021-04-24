package com.orders.repostitoy;

import com.orders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findByUserName(String name);
}
