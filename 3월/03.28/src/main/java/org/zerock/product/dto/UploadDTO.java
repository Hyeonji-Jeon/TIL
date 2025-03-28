package org.zerock.product.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class UploadDTO {

	private String title;
	
	private MultipartFile[] files;
}
