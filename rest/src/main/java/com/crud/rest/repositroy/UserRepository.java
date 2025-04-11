package com.crud.rest.repositroy;

import com.crud.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	public User findByusername(String username);
	//public List<User> findByusernameOrderByCreatedDateCreatedByDesc(String username);
}
