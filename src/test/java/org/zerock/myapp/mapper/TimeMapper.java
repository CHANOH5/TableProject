package org.zerock.myapp.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT current_date FROM dual")
	public abstract Date getNow(); // 현재 시간 얻어주는 메소드
	
	// 메퍼 인터페이스 생성 이제 config(설정파일)에 알려주자
	
	// 어노테이션 x
	public abstract Date getNow2();  // XML
	
}
