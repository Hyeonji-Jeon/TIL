package org.zerock.product.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.product.dto.UploadDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

	@GetMapping("ex1")
	public void ex1GET() {
		
	}
	
	@PostMapping("ex1")
	public void ex1Post(UploadDTO uploadDTO) {
		log.info("--------------------------");
		log.info(uploadDTO);
		
		MultipartFile[] files =  uploadDTO.getFiles();
		
		for(MultipartFile file:files) {
			
			File target = new File("C:\\upload\\" + file.getOriginalFilename() );
			
			try {
				file.transferTo(target);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}//end for
		
	}
}
