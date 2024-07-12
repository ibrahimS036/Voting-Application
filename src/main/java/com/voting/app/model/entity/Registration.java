package com.voting.app.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Registration")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "USER_NAME",unique = true,nullable = false,length = 50)
	private String userName;
	@Column(name = "EMAIL",unique = true,nullable = false,length = 100)
	private String email;
	@Column(name = "PHONE_NUMBER",unique = true,nullable = false,length = 10)
	private long phoneNumber;
	@Column(name = "PASSWORD",nullable = false,length = 100)
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Registration(long id, String userName, String email, long phoneNumber, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	public Registration() {
		super();
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, phoneNumber, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password)
				&& phoneNumber == other.phoneNumber && Objects.equals(userName, other.userName);
	}
}