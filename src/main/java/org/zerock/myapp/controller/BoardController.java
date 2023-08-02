package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.PageMakeDTO;
import org.zerock.myapp.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardService;
	
//	/* 게시판 목록 페이지 진입 */
//	@GetMapping("/list")
//	public void boardListGET(Model model) {
//		
//		log.info(" >>>>>>>>>> 게시판 목록 페이지 진입 <<<<<<<<<<< ");
//		
//		model.addAttribute("list", boardService.getList());
//		
//	} // boardListGET(
	
	/* 게시판 목록 페이지 진입 ( 페이징 적용 ) */
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		log.info(" >>>>>>>>>> 게시판 목록 페이지 진입 <<<<<<<<<<<");
		
		model.addAttribute("list", boardService.getListPaging(cri));
		
		int total = boardService.getTotal();
		
		PageMakeDTO pageMake = new PageMakeDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMake);
		
	} //boardListGET

	/* 게시판 등록 페이지 진입 */
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		
		log.info(" >>>>>>>>>> 게시판 등록 페이지 진입 <<<<<<<<<<< ");
		
	} // boardEnrollGET
	
	/* 게시판 등록 */
	@PostMapping("/enroll")
	public String boardEnrollPost(BoardVO board, RedirectAttributes rttr) {
		
		log.info(" >>>>>>>>>>> BoardVO : <<<<<<<<<<<<<< " + board );
		
		boardService.enroll(board);
		
		rttr.addFlashAttribute("result", "enroll success");
		
		return "redirect:/board/list";
		
	} // BoardEnrollPOST

	/* 게시판 상세조회 */
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model, Criteria cri) {
		
		model.addAttribute("pageInfo", boardService.getPage(bno));
		
		model.addAttribute("cri", cri);
		
	}
	
	/* 수정 페이지 이동 */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {
		
		model.addAttribute("pageInfo", boardService.getPage(bno));
		
		
	}
	
	/* 페이지 수정 */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		
		boardService.modify(board);
		
		rttr.addFlashAttribute("result", "modify success");
		
		return "redirect:/board/list";
	}
	
	/* 게시판 삭제 */
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {
	
		log.trace(">>>>>>>>>>>> boardDeletePOST() invoked <<<<<<<<<<<<<<< ");
		
		boardService.delete(bno);
		
		rttr.addFlashAttribute("result", "delete success");
		
		return "redirect:/board/list";
		
	}
	
}
