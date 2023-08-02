package org.zerock.myapp.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardServiceTest {
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
	@Test
	@Order(1)
	@DisplayName("BoardServce 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testEnroll() {
		
		BoardVO vo = new BoardVO();
		
        vo.setTitle("service test!!!");
        vo.setContent("service test!!!");
        vo.setWriter("service test!!!");
        
        service.enroll(vo); 
	} //testEnroll
	
	@Test
	@Order(2)
	@DisplayName("BoardService getList메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void testGetList() {
		
		
		List list = service.getList();
		
//		for(int i = 0; i <= list.size(); i++) {
//			log.trace("" + list.get(i));
//		}
		
		for(Object a : list) {
			log.trace("" + a);
		}
		
	} // testGetList
	
	@Test
	@Order(3)
	@DisplayName("BoardService getPage메서드 테서트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void testGetPage() {
		
		int bno = 6;
		
		log.info("" + service.getPage(bno));
		
	} // testGetPage
	
	@Test
	@Order(4)
	@DisplayName("BoardService modify메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void testModift() {
		
		BoardVO board = new BoardVO();
		board.setBno(9);
		board.setTitle("수정 히히2");
		board.setContent(" 수정 히히2");
		
		int result = service.modify(board);
		log.info("result" + result);
		
		
	} //testModify
	
	@Test
	@Order(5)
	@DisplayName("BoardServie delete 메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void testDelete() {
		
		log.trace(">>>>>>>>>>>> testDelete() invoked <<<<<<<<<<<");
		
		int result = service.delete(8);
		
		log.trace("result : " + result );
		
	}
	
	@Test
	@Order(6)
	@DisplayName("BoardService getListPaging 메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void getListPagingTest() {
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(3);
		
		List list = service.getListPaging(cri);
		
		list.forEach(board -> log.info("" + board));
		
	}
	
}
