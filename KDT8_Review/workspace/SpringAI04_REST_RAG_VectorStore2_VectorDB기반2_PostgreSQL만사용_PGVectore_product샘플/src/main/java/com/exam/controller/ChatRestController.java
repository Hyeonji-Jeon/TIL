package com.exam.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.ProductDTO;
import com.exam.entity.Product;
import com.exam.service.ChatService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ChatRestController {

	
	ChatService chatService;

	public ChatRestController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	/*
	    실습전에 PgVector 에 있는 vector_store 테이블 삭제하고
	    schema.sql 파일내의 SQL 문을 먼저 실행한다.
	
	*/
	// http://localhost:8090/app/ai/vectorstore/add
		/*
		 [
			 {
               "id": 1000,
			   "name":"무선 블루투스 이어폰",
			   "description": "고음질 사운드와 노이즈 캔슬링 기능을 갖춘 무선 블루투스 이어폰"
			 },
			 {
               "id": 1001,
			   "name":"유선 이어폰",
			   "description": "저음질 사운드와 노이즈 캔슬링 기능은 못 갖춘 유선 이어폰"
			 },
		 	{
               "id": 1002,
			   "name":"게이밍 마우스",
			   "description": "정밀한 조작이 가능한 RGB 게이밍 마우스입니다."
			 },
		 	{
               "id": 1003,
			   "name":"스탠딩 책상",
			   "description": "높이 조절이 가능한 전동 스탠딩 데스크입니다."
			 },
			 {
               "id": 1004,
			   "name":"텀블러",
			   "description": "보온 보냉 기능이 뛰어난 스테인리스 텀블러입니다."
			 },
			 {
               "id": 10005,
			   "name":"휴대용 선풍기",
			   "description": "USB 충전식의 휴대용 미니 선풍기로 여름철 필수 아이템입니다."
			 },
			 {
               "id": 1006,
			   "name":"노트북 거치대",
			   "description": "인체공학적 디자인의 알루미늄 노트북 스탠드입니다."
			 },
			  {
                "id": 1007,
			   "name":"무선 충전기",
			   "description": "QI 지원 스마트폰을 위한 고속 무선 충전기입니다."
			 },
			  {
                "id": 1008,
			   "name":"LED 스탠드",
			   "description": "눈부심 방지 기능이 있는 LED 데스크 스탠드입니다."
			 },
			  {
                "id": 1009,
			   "name":"스마트 워치",
			   "description": "심박수 측정과 운동 기록 기능이 탑재된 스마트 워치입니다."
			 },
			  {
                "id": 1010,
			   "name":"커피 그라인더",
			   "description": "원두를 신선하게 갈아주는 전동 커피 그라인더입니다."
			 }
		 ]
		
		*/
		@PostMapping("/ai/vectorstore/addAll")
		public ResponseEntity<List<ProductDTO>> product_addAll(@RequestBody List<ProductDTO> list) {
			
			chatService.product_addAll(list);
			return ResponseEntity.ok(list);
		}
		
	// http://localhost:8090/app/ai/vectorstore/add
	/*
	 {
	   "id":2000,
	   "name":"유무선 모두 가능한 블루투스 헤드폰",
	   "description": "중저음 음질 사운드와 노이즈 캔슬링 기능을 갖춘 유무선 블루투스 헤드폰"
	 }
	
	*/
	@PostMapping("/ai/vectorstore/add")
	public ResponseEntity<ProductDTO> product_add(@RequestBody ProductDTO dto) {
		
		chatService.product_add(dto);
		return ResponseEntity.created(null).body(dto);
	}	
	
	// http://localhost:8090/app/searchString?query="이어폰 및 헤드폰 찾아줘"
	 @GetMapping("/searchString")
	 public String similar(@RequestParam String query) throws IOException {
		 String response = chatService.generateAnswerWithVectorStoreSimilaritySearchString(query);
			
			return response;
	 }
	
}