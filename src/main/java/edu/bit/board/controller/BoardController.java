package edu.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

@Controller
@AllArgsConstructor
@Log4j
public class BoardController {
	
	//������ 5�� �����ڰ� ������ Auto(�ڵ����� �־���) 
	private BoardService service;

	
//�������� �Ʒ� �ڵ�ó�� ���� �־���� �ߴ�. (@AllArgsConstructor �̰� ���п�)
//	@Inject
//	public BoardController(BoardService service) {
//		this.service = service;
//	}
	
	@GetMapping("/list") // get ������� �޾Ƽ� getmapping "@RequestMapping" �̰͵� ����ص� ����
	public void list(Model model) { 
	   log.info("list");
	   model.addAttribute("list", service.getList());

	}	
	
	@GetMapping("/content_view") 
	public String content_view(BoardVO boardVO, Model model) {
	   log.info("content_view");
	   model.addAttribute("content_view", service.get(boardVO.getbId()));

	   
	   return "content_view";
	}
	
	@GetMapping("/delete") 
	public String delete(BoardVO boardVO) {
	   log.info("delete");
	   
	    service.remove(boardVO.getbId());

	   
	    return "redirect:list";
	}
	
	@GetMapping("/write_view") 
	public String write_view() {
	   log.info("write_view");
	   return "write_view";
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		
		log.info("write");
		
		service.writeBoard(boardVO);
		
		
		return "redirect:list";
	}
	
	
	@GetMapping("/reply_view") 
	public String reply_view(BoardVO boardVO, Model model) {
	
		log.info("reply_view");
		
		model.addAttribute("reply_view", service.get(boardVO.getbId()));
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) throws Exception {
		
		log.info("reply");
		
		service.writeReply(boardVO);
		
		
		return "redirect:list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		
		log.info("modify");
		
		service.modify(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/ajax/list")
	public String ajaxList() {
		
		log.info("ajaxList");
		return "ajaxList";
	}
	
	
	
}
	
//test�� �Ϸ��� "/list"�� �޾Ƴ����ϴµ�,
//�޾Ƴ��� ��ü�� ��Ĺ���� url ġ�� ������ ���� �޾Ƴ��� �ϴµ�
//�ᱹ ���� �׽�Ʈ �Ϸ��� �������� �������Ѵ�.
//�������� �������ϴ� ���� �־�� �ϴµ�
//������ �ϳ� �������. �װ��� "mock" 





