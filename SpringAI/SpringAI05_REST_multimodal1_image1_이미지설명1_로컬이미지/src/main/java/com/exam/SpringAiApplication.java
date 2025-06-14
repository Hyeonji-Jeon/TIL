package com.exam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiApplication.class, args);
	}

//	@Bean
	public CommandLineRunner runner(ChatClient.Builder builder) {
	    return args -> {
	        ChatClient chatClient = builder.build();
	        String response = chatClient.prompt("자바개발자가 알아야될 스킬은 뭐야").call().content();							
	        System.out.println(response);
	        
	        /*
	         자바 개발자가 알아야 할 스킬은 다양합니다. 아래는 주요 스킬과 지식 영역을 정리한 목록입니다:

			1. **자바 기본 및 고급 문법**:
			   - 객체지향 프로그래밍(OOP) 개념 (클래스, 상속, 다형성, 캡슐화 등)
			   - 예외 처리
			   - 자바 컬렉션 프레임워크
			   - 스트림 API 및 람다 표현식
			
			2. **프레임워크 및 라이브러리**:
			   - Spring Framework (Spring Boot, Spring MVC 등)
			   - Hibernate (ORM)
			   - Maven 또는 Gradle (빌드 도구)
			   - JUnit 및 Mockito (테스트 프레임워크)
			
			3. **웹 개발**:
			   - RESTful API 설계 및 구현
			   - HTML, CSS, JavaScript 기본 지식
			   - 프론트엔드 프레임워크 (React, Angular 등)와의 통합
			
			4. **데이터베이스**:
			   - SQL 및 관계형 데이터베이스 (MySQL, PostgreSQL 등)
			   - NoSQL 데이터베이스 (MongoDB 등)
			   - 데이터베이스 설계 및 최적화
			
			5. **버전 관리**:
			   - Git 및 GitHub 사용법
			   - 브랜치 전략 및 협업 시나리오
			
			6. **DevOps 및 CI/CD**:
			   - Docker와 컨테이너 기술
			   - Jenkins, GitLab CI 등 CI/CD 도구 사용
			   - 클라우드 서비스 (AWS, Azure, GCP 등) 기본 지식
			
			7. **소프트웨어 설계 및 아키텍처**:
			   - 디자인 패턴 (싱글톤, 팩토리, 옵저버 등)
			   - 마이크로서비스 아키텍처
			   - SOLID 원칙 및 소프트웨어 품질
			
			8. **성능 최적화 및 보안**:
			   - 애플리케이션 성능 모니터링
			   - 보안 취약점 이해 및 방어 (SQL 인젝션, XSS 등)
			
			9. **문서화 및 커뮤니케이션**:
			   - 코드 주석 및 문서화
			   - 팀 내 커뮤니케이션 및 협업 능력
			
			10. **기타**:
			    - Agile 및 Scrum 방법론 이해
			    - 문제 해결 능력 및 알고리즘 기초
			
			이 외에도, 최신 기술 트렌드에 대한 지속적인 학습이 중요합니다. 자바 생태계는 빠르게 변화하고 있으므로, 새로운 도구와 기술을 배우는 것이 필요합니다.

	     
	        */
	    };
	}

}
