package org.zerock.myapp.mapper;

import java.util.List;

import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;

public interface BoardMapper {
	
	/* 게시판 등록 쿼리 요청 */
	public void enroll(BoardVO board);
	
	/* 게시판 전체목록 쿼리 요청 */
	public List<BoardVO> getList();
	
	/* 게시판 목록 쿼리 요청(페이징 처리 적용) */
	public List<BoardVO> getListPaging(Criteria cri);
	
	/* 게시판 상세 정보 요청 */
	public BoardVO getPage(int bno);
	
	/* 게시물 수정 */
	public int modify(BoardVO board);
	
	/* 게시물 삭제 */
	public int delete(int bno);
	
	/* 게시물 총 개수 */
	public int getTotal();

}
