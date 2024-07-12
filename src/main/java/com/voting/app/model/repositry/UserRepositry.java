package com.voting.app.model.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.app.model.entity.User;

public interface UserRepositry extends JpaRepository<User, Long>{
	public abstract User findByUserName(String userName);
}
