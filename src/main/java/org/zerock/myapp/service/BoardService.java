package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;

public interface BoardService {

	/* 게시판 등록 수행 */
	public void enroll(BoardVO board);
	
	/* 게시판 목록 쿼리 수행 */
	public List<BoardVO> getList();
	
	/* 게시판 목록 쿼리 수행 ( 페이징 적용 ) */
	public List<BoardVO> getListPaging(Criteria cri);
	
	/* 게시판 상세 페이지 쿼리 수행 */
	public BoardVO getPage(int bno);
	
	/* 게시물 수정 쿼리 수행 */
	public int modify(BoardVO board);
	
	/* 게시물 삭제 쿼리 수행 */
	public int delete(int bno);
	
	/* 게시물 총 갯수 */
	public int getTotal();
	
	
}
