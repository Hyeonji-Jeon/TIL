package org.zerock.product.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {

	private Integer pno;
	private String pname;
	private String pdesc;
	
	private int price;
	
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	private java.util.List<String> fileNames = new ArrayList<>(); //문자열 리스트 - DB와 동일

	//등록 수정 
	private MultipartFile[] files;
	
}





