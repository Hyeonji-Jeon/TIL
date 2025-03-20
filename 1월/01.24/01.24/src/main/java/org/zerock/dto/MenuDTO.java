package org.zerock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//데이터 위주의 클래스
//여러 개, 자주
//인스턴스 변수가 우선
//식별 값을 가지는 경우가 많다
//명사

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

	//메뉴 번호
	private Long mno;
	
	//메뉴 이름
	private String mname;
	
	//이미지 파일 이름
	private String fileName;
	
	//메뉴 가격
	private int price;
	
	
	
}
