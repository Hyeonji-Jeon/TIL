package org.zerock.product.service;

import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.product.dto.ProductDTO;
import org.zerock.product.dto.ProductListDTO;

public interface ProductService {

	Integer add(ProductDTO productDTO);
	
	PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO);
	
	ProductDTO get(Integer pno);
	
	void modify(ProductDTO productDTO);
	
	
}
