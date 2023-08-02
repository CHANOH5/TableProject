package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2	
@Data
public class BoardVO {
	
	/* 게시물 번호 */
	private int bno;
	
	/* 제목 */
	private String title;
	
	/* 내용 */
	private String content;
	
	/* 작성자 */
	private String writer;
	
	/* 등록일 */
	private Date regdate;
	
	/* 수정일 */
	private Date updateDate;

}
