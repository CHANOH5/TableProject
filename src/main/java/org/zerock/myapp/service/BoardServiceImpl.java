package org.zerock.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
@AllArgsConstructor

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void enroll(BoardVO board) {
		
		mapper.enroll(board);
		
	} // enroll

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
		
	} // getList

	@Override
	public BoardVO getPage(int bno) {
		
		return mapper.getPage(bno);
	} // getPage
	
	@Override
	public int modify(BoardVO board) {
	
		return mapper.modify(board);
	} // modify

	@Override
	public int delete(int bno) {
		
		return mapper.delete(bno);
		
	} // delete

	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		
		return mapper.getListPaging(cri);
		
	} // getListPaging

	@Override
	public int getTotal() {
		
		return mapper.getTotal();
	} // getTotal
	
}
