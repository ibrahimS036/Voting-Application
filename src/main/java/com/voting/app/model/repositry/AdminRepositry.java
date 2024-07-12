package com.voting.app.model.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.app.model.entity.Admin;

public interface AdminRepositry extends JpaRepository<Admin, String>{

	public abstract Admin findByUserNameAndPassword(String userName, String password);
}
