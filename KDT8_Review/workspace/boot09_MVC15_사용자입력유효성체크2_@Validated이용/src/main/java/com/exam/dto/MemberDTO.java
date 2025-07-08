package com.exam.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MemberDTO {


	String userid;
	String passwd;
	String username;
	String phone;
	LocalDate targetDate;

	public MemberDTO() {}

	public MemberDTO(String userid, String passwd, String username, String phone, LocalDate targetDate) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.phone = phone;
		this.targetDate = targetDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", phone=" + phone
				+ ", targetDate=" + targetDate + "]";
	}
	
	
	
}
