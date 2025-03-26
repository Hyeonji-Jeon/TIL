package org.zerock.product.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ProductListDTO extends ProductDTO{
	
	private String fileName;
		

}
