package org.zerock.product.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.member.dto.MemberDTO;
import org.zerock.product.dto.ProductDTO;
import org.zerock.product.dto.ProductListDTO;
import org.zerock.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;


	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("ex1")
	public void ex1GET(@AuthenticationPrincipal MemberDTO userDetails) {
		log.info(""+userDetails);
	}
	
	@GetMapping("list")
	public void list(@ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
		
		PageResponseDTO<ProductListDTO> res = service.list(requestDTO);
		
		model.addAttribute("res", res);
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("read/{pno}")
	public String read(
			@PathVariable("pno")Integer pno,
			@ModelAttribute("requestDTO") PageRequestDTO requestDTO,
			Model model) {
		
		model.addAttribute("product", service.get(pno));
		
		return "product/read";
	}
	
	@GetMapping("modify/{pno}")
	public String modifyGET(
			@PathVariable("pno")Integer pno,
			@ModelAttribute("requestDTO") PageRequestDTO requestDTO,
			Model model) {
		
		model.addAttribute("product", service.get(pno));
		
		return "product/modify";
	}
	
	@PostMapping("modify/{pno}")
	public String modifyPOST(
			@PathVariable("pno")Integer pno,
			PageRequestDTO requestDTO,
			ProductDTO productDTO) {
		
		log.info("pno: " + pno);
		
		//기존에 파일들을 알아두어야 함 - 나중에 필요없는 파일들을 삭제 
		List<String> oldFiles = service.get(pno).getFileNames();
		
		//double checking
		productDTO.setPno(pno);
		
		MultipartFile[] files =  productDTO.getFiles();
		
		//업로드된 파일의 이름들
		List<String> fileNames = new ArrayList<>();
		
		for(MultipartFile file:files) {
			
			log.info("-------------");
			String contentType = file.getContentType();
			
			if(contentType.startsWith("image") == false) {
				continue;
			}
			
			String uuid = UUID.randomUUID().toString();
			
			String saveFileName = uuid +"_"+file.getOriginalFilename();
			
			String thumbFileName = "s_"+ saveFileName;
			
			File target = new File("C:\\upload\\" + saveFileName );
			
			File thumbFile = new File("C:\\upload\\" + thumbFileName);
			
			try {
				file.transferTo(target);
				
				Thumbnails.of(target)
		        .size(200,200)
		        .toFile(thumbFile);
				
				fileNames.add(saveFileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end for
		
		//최종 결과물 
		productDTO.getFileNames().addAll(fileNames);
		
		log.info("--------------------");
		log.info(productDTO);
		log.info("--------------------");
		
		//서비스를 통해서 DB에 반영 
		
		service.modify(productDTO);
		
		
		//기존에 존재했지만 화면에서 삭제된 파일들은 지워야 함 
		List<String> recent =  productDTO.getFileNames();
		
		List<String> filteredList = oldFiles.stream()
			    .filter(oldFile -> !recent.contains(oldFile)) // recent에 없는 항목 필터링
			    .collect(Collectors.toList());
		
		log.info("--------------------");
		log.info(filteredList);
		log.info("--------------------");
		
		filteredList.forEach(targetFile -> {
			
			new File("C:\\upload\\"+ targetFile).delete();
			new File("C:\\upload\\s_"+ targetFile).delete();
			
		});
		
		return "redirect:/product/read/"+pno+ requestDTO.getPageLink();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("add")
	public void addPost(ProductDTO productDTO) {
		
		log.info("--------------------------");
		log.info(productDTO);
		
		MultipartFile[] files =  productDTO.getFiles();
		
		//업로드된 파일의 이름들
		List<String> fileNames = new ArrayList<>();
		
		for(MultipartFile file:files) {
			
			log.info("-------------");
			String contentType = file.getContentType();
			
			if(contentType.startsWith("image") == false) {
				continue;
			}
			
			String uuid = UUID.randomUUID().toString();
			
			String saveFileName = uuid +"_"+file.getOriginalFilename();
			
			String thumbFileName = "s_"+ saveFileName;
			
			File target = new File("C:\\upload\\" + saveFileName );
			
			File thumbFile = new File("C:\\upload\\" + thumbFileName);
			
			try {
				file.transferTo(target);
				
				Thumbnails.of(target)
		        .size(200,200)
		        .toFile(thumbFile);
				
				fileNames.add(saveFileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end for
		
		//최종 결과물 
		productDTO.getFileNames().addAll(fileNames);
		
		log.info("--------------------");
		log.info("--------------------");
		log.info(productDTO);
		log.info("--------------------");
		
		Integer pno = service.add(productDTO);
		
		log.info("pno: " + pno);
		log.info("--------------------");
	}
}










