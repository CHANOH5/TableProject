package org.zerock.myapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	
	/* 현재 페이지 */
	private int pageNum;
	
	/* 한 페이지 당 보여질 게시물의 수 */
	private int amount;
	
	/* 기본 생성자 -> 기본 세팅 : pageNum = 1, amount 10 */
	public Criteria() {
		this(1, 10);
	}
	
	/* 생성자 */
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
