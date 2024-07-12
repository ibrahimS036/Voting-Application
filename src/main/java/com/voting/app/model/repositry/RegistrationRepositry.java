package com.voting.app.model.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.app.model.entity.Registration;

public interface RegistrationRepositry extends JpaRepository<Registration, Long>{

	Registration findByUserNameAndPassword(String username, String password);
	Registration findByEmailOrPhoneNumberOrUserName(String email, long phoneNumber, String userName);
	Registration findByUserName(String userName);
}