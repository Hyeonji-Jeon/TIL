package org.zerock.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagingDTO {

	private int start; //페이지 시작 번호 
	
	private int end; //마지막 페이지 번호
	
	private int current; //현재 페이지 번호
	
	private boolean prev;
	
	private boolean next;
	
	private int total;
	
	public PagingDTO(int pageNum, int total) {
		
		this.total = total;
		
		this.current = pageNum;
		
		int tempEnd = (int)(Math.ceil( pageNum / 10.0) * 10); //20 	//Math.ceil : 소수점 반올림
		
		this.start = tempEnd - 9; //11
		
		if(this.start != 1) {	//start가 1이 아니면 이전버튼은 생긴다
			this.prev = true;
		}
		
		int realEnd = (int)( Math.ceil(total/ 10.0) );	//10개씩 나오니까 5001개의 데이터면 501페이지가 출력되겠지
		
		if(realEnd > tempEnd) {	//end가 501이 안됐으면 다음 버튼이 있어야해
			this.next = true;
		}
		
		if(realEnd < tempEnd) {	//근데 end가 501보다 커진다 ? 그럼 더이상 없으니까 다음버튼은 없어야하고
			this.end = realEnd;
		}else {
			this.end = tempEnd;	//end는 501이 되겠지 ~
		}
		
		
		
	}
	
}