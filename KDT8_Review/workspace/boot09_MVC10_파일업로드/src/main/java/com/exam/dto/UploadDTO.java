package com.exam.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {

	MultipartFile theFile;
	String theText;
	
	public UploadDTO() {}

	public UploadDTO(MultipartFile theFile, String theText) {
		this.theFile = theFile;
		this.theText = theText;
	}

	public MultipartFile getTheFile() {
		return theFile;
	}

	public void setTheFile(MultipartFile theFile) {
		this.theFile = theFile;
	}

	public String getTheText() {
		return theText;
	}

	public void setTheText(String theText) {
		this.theText = theText;
	}

	@Override
	public String toString() {
		return "UploadDTO [theFile=" + theFile + ", theText=" + theText + "]";
	}

	
	
}
