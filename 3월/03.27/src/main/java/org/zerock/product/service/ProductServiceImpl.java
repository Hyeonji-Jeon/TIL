package org.zerock.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.product.dto.ProductDTO;
import org.zerock.product.dto.ProductListDTO;
import org.zerock.product.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

	//의존성 주입 (생성자 주입)
	private final ProductMapper mapper;
	
	@Override
	public Integer add(ProductDTO productDTO) {
		
		mapper.insertProduct(productDTO);
		
		Integer pno = productDTO.getPno();
		
		List<String> fileNames = productDTO.getFileNames();
		
		mapper.insertImgs(fileNames, pno);
		
		return pno;
	}
	
	@Override
	public PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO) {
		
		List<ProductListDTO> dtoList = mapper.list(requestDTO);
		
		int total = mapper.listCount(requestDTO);
		
		return PageResponseDTO.<ProductListDTO>withAll()
				.dtoList(dtoList)
				.total(total)
				.pageRequestDTO(requestDTO)
				.build();
	}
	
	@Override
	public ProductDTO get(Integer pno) {
		
		return mapper.selectOne(pno);
	}
	
	@Override
	public void modify(ProductDTO productDTO) {
		
		Integer pno = productDTO.getPno();
		//모든 파일들 삭제 
		mapper.deleteFiles(pno);
		
		mapper.update(productDTO);
		
		mapper.insertImgs(productDTO.getFileNames(), pno);
		
		
	}

}








