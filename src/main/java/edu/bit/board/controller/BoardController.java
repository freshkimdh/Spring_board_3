package edu.bit.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.RecVO;
import edu.bit.board.vo.ScoreVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

@Controller
@AllArgsConstructor
@Log4j
public class BoardController {
	
	//스프링 5는 생성자가 있으면 Auto(자동으로 넣어줌) 
	private BoardService service;

	
//기존에는 아래 코드처럼 직접 넣었어야 했다. (@AllArgsConstructor 이거 덕분에)
//	@Inject
//	public BoardController(BoardService service) {
//		this.service = service;
//	}
	
	 @GetMapping("/list3")
	 public void list3(Criteria cri, Model model) {	
		 log.info("list3");
		 log.info(cri);
		 model.addAttribute("list", service.getList(cri));	
		 
		 int total = service.getTotal(cri);
		 log.info("total" + total);
		 
		 model.addAttribute("pageMaker", new PageDTO(cri,total));	
	 }	
	
	
	
	
	
	@GetMapping("/list") // get 방식으로 받아서 getmapping "@RequestMapping" 이것도 사용해도 무관
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
	
	
	@GetMapping("/restful/recArea")
	public String recArea() {
		
		log.info("recArea");
		return "recAjax";
	}
	
	@ResponseBody
	@RequestMapping("/restful/recAjax")
	public Double recArea(RecVO rec) {
		
		log.info("recArea");
		return rec.getArea();
	}
	
	
	@GetMapping("/restful/Score")
	public String Score() {
		
		log.info("Score");
		return "scoreSum";
	}
	
	@ResponseBody
	@RequestMapping("/restful/scoreSum")
	public Double scoreSum(ScoreVO score) {
		
		log.info("scoreSum");
		return score.getSum();
	}
	
	
	
	
	
	
}
	
//test를 하려면 "/list"를 받아내야하는데,
//받아내는 주체는 톰캣에서 url 치고 들어오는 것을 받아내야 하는데
//결국 위를 테스트 하려면 웹서버를 돌려야한다.
//웹서버를 돌려야하는 뭐가 있어야 하는데
//별도로 하나 만들었다. 그것이 "mock" 





