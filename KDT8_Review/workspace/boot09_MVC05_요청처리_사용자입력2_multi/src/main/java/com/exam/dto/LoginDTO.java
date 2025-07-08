package com.exam.dto;

import java.util.List;

public class LoginDTO {

	String userid;
	String passwd;
	
	List<String> hobby;
//	String [] hobby;
	
	public LoginDTO() {}

	public LoginDTO(String userid, String passwd, List<String> hobby) {
		this.userid = userid;
		this.passwd = passwd;
		this.hobby = hobby;
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

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", passwd=" + passwd + ", hobby=" + hobby + "]";
	}

	
	
	
}
