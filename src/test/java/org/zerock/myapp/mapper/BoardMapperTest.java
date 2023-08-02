package org.zerock.myapp.mapper;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
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
public class BoardMapperTest {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper; // CartMapper 타입이 빈이 등록
	 
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		Objects.requireNonNull(this.mapper);
		log.info("\t+this.mapper:{}, type:{}", this.mapper, this.mapper.getClass().getName());
	} // beforeAll
	
	@Test
	@Order(1)
	@DisplayName("enrollTest")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void enrollTest() {
		log.trace(">>>>>>>>>>>> enroll() invoked <<<<<<<<<<<<<");
		
		BoardVO vo = new BoardVO();
		
        vo.setTitle("mapper test!!!");
        vo.setContent("mapper test!!!");
        vo.setWriter("mapper test!!!");
        
        mapper.enroll(vo);
		
	} // enroll
	
	@Test
	@Order(2)
	@DisplayName("getListTest")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void getListTest() {
		log.trace(">>>>>>>>>>> getListTest() invoked <<<<<<<<<<<");

		List list = mapper.getList();
		
		/* for문 */
//		for(int i = 0; i <= list.size(); i++) {
//			log.trace("" + list.get(i));
//		}
		
		/* enhance for문 */
		for(Object a : list) {
			log.trace("" + a);
		}
		
	} // getListTest
	
	@Test
	@Order(3)
	@DisplayName("BoardMapper의 getPage메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void getPageTest() {
		
		log.trace(">>>>>>>>>>> getPageTest() invoekd <<<<<<<<<<<<");
		
		int bno = 6;
		
		log.trace("" + mapper.getPage(bno));
		
	} // getPageTest
	
	@Test
	@Order(4)
	@DisplayName("BoardMapper의 modfiy메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void modifyTest() {
		
		log.trace(">>>>>>>>>>>> modify() invoked <<<<<<<<<<<<<<");
		
		BoardVO board = new BoardVO();
		board.setBno(9);
		board.setTitle("수정 히히");
		board.setContent("수정 돼라!");
		
		int result = mapper.modify(board);
		log.trace("" + result);
		
	}
	
	@Test
	@Order(5)
	@DisplayName("BoardMapper delete 메소드 테스트")
	@Timeout(value =1, unit=TimeUnit.MINUTES)
	public void deleteTest() {
		
		int result = mapper.delete(7);
		log.trace("delte" + result);
		
	}
	
	@Test
	@Order(6)
	@DisplayName("BoardMapper getListPaging 메서드 테스트")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void getListPagingTest() {
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(3);
		
		List list = mapper.getListPaging(cri);
		
		list.forEach(board -> log.info("" + board));
		
	}
	
}
