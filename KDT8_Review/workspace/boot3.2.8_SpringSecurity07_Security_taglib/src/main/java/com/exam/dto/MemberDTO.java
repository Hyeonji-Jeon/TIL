package com.exam.dto;

import org.apache.ibatis.type.Alias;

import jakarta.validation.constraints.NotBlank;

@Alias("MemberDTO")
public class MemberDTO {

	String userid;
	String passwd;
	
	@NotBlank(message = "username 필수")
	String username;
	
	public MemberDTO() {}

	public MemberDTO(String userid, String passwd, String username) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
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

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + "]";
	}
	
	
}
