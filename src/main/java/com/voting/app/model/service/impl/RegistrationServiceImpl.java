package com.voting.app.model.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.app.model.entity.Registration;
import com.voting.app.model.repositry.RegistrationRepositry;
import com.voting.app.model.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepositry registrationRepositry;

	@Override
	public boolean save(Registration bean) {
		Registration number = this.registrationRepositry.findByEmailOrPhoneNumberOrUserName(bean.getEmail(), bean.getPhoneNumber(),bean.getUserName());
		if(number==null) {			
			this.registrationRepositry.save(bean);
			return true;
		}
		return false;
	}

	@Override
	public Registration loginMatch(Registration bean,HttpSession httpSession) {
		Registration password = this.registrationRepositry.findByUserNameAndPassword(bean.getUserName(),bean.getPassword());
		return password;
	}
}