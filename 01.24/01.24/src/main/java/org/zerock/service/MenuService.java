package org.zerock.service;

import java.util.List;

import org.zerock.dto.MenuDTO;

public class MenuService {
	
	public java.util.List<MenuDTO> getMenus(){
		
		return List.of(
				MenuDTO.builder().mno(1L).mname("Newyork Pizza").price(20000).fileName("pizza1.jpg").build(),
				MenuDTO.builder().mno(2L).mname("Cicago Pizza").price(23000).fileName("pizza2.jpg").build(),
				MenuDTO.builder().mno(3L).mname("Ditroit Pizza").price(25000).fileName("pizza3.jpg").build()
				);
		
				
//		List<MenuDTO> list = new ArrayList<>();
//		
//		list.add(
//				MenuDTO.builder()
//				.mno(1L)
//				.mname("Newyork Pizza")
//				.price(20000)
//				.fileName("pizza1.jpg")
//				.build()
//				);
//		
//		return list;
		
	}

}
