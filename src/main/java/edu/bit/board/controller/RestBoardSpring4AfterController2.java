package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

//spring v4.0 이전버젼 (@Controller + @ResponseBody)
@Controller
@AllArgsConstructor
@Log4j
@RestController // (controller + @ResponsBody)
public class RestBoardSpring4AfterController2 {
	
	private BoardService boardService;
	
	
	@RequestMapping("/restful/after")
	public List<BoardVO> before() {
	
	log.info("/restful/after");
	List<BoardVO> list = boardService.getList();
	
	return list;
	
	}
	
	
}
	



