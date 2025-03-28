package org.zerock.member.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.member.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@Log4j2
@WebAppConfiguration
@ContextConfiguration(
		{
			"file:src/main/webapp/WEB-INF/spring/root-context.xml",
			"file:src/main/webapp/WEB-INF/spring/servlet-context.xml",
			"file:src/main/webapp/WEB-INF/spring/security-context.xml"
			}
		)

public class MemberMapperTests {

	@Autowired(required = false)
	private PasswordEncoder passwordEncoder;
	
	@Autowired(required = false)
	private MemberMapper mapper;
	
	//원래는 트랜잭션 처리가 필요함 
	@Test
	public void testInsert() {
		
		//20명 user1 - user20 , 1111, 
		// user1 - user9 까지는 'USER' 
		// user10 - user19 까지는 'USER','MANAGER'
		// user20 'USER','MANAGER','ADMIN'
		
		for(int i = 1; i <= 20; i++) {
			
			MemberDTO dto = new MemberDTO();
			
			dto.setMid("user"+i);
			dto.setMpw(passwordEncoder.encode("1111"));
			dto.setMname("사용자"+i);
			dto.setEmail("user"+i+"@aaa.com");
			
			if(i < 10) {
				dto.setRoleNames(List.of("USER"));
			}else if(i < 20) {
				dto.setRoleNames(List.of("USER","MANAGER"));
			}else {
				dto.setRoleNames(List.of("USER","MANAGER","ADMIN"));
			}
			
			mapper.insert(dto);
			mapper.insertRoles(dto);
			
		}//end for
		
		
	}
	
	@Test
	public void testSelect() {
		
		MemberDTO dto = mapper.selectByMid("user20");
		
		log.info(dto);
		
	}
	
	@Test
	public void test1() {
		
		log.info(passwordEncoder);
		
		for(int i = 0; i < 10; i++) {
			String enStr = passwordEncoder.encode("1111");
			log.info(enStr);
			
			boolean result = passwordEncoder.matches("1111", enStr);
			log.info(result);
		}//end for
	}
	
	
}






