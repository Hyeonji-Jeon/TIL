package org.zerock.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.product.dto.ProductDTO;
import org.zerock.product.dto.ProductListDTO;

public interface ProductMapper {

	//상품 자체의 등록 
	int insertProduct(ProductDTO productDTO);
	
	//상품 이미지 등록 
	int insertImgs(@Param("fileNames") List<String> fileNames, @Param("pno")  Integer pno);
	
	List<ProductListDTO> list(PageRequestDTO requestDTO);
	
	int listCount(PageRequestDTO requestDTO);
	
	ProductDTO selectOne(Integer pno);
	
	int deleteFiles(Integer pno);

	int update(ProductDTO productDTO);
	
}
