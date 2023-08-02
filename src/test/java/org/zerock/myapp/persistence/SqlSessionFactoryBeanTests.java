package org.zerock.myapp.persistence;

import java.sql.Connection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
//@AllArgsConstructor	// 하나면 의존성자동주입기능 spring4.3부터 되는거 확인해보기 -> 에러남, junit에서는 에러남

//spring framwork도 함께 구동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SqlSessionFactoryBeanTests {

	@Setter(onMethod_= @Autowired)
	private SqlSessionFactory sqlSessionFactory; // sqlSessionfactory 여기에 넣어라
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoekd."); 
		
		assert this.sqlSessionFactory != null;
		log.info("\t+ this.sqlSessionFactory : {}", this.sqlSessionFactory);
	}
	
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: SqlSessionFactoryBean")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testSqlSessionFactoryBean() {
		log.trace("testSqlSessionFactoryBean() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		log.trace("\t+ sqlSession: {}", sqlSession);
		
		Connection conn = sqlSession.getConnection();
		Objects.requireNonNull(conn);
		log.trace("\t+ conn: {}", conn);
	}
} // end class
