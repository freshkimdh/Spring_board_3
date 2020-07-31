package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class RestBoardSpring4BeforeController {
	
	private BoardService boardService;
	
	@ResponseBody // restful 관련 어노테이션이며, 메소드의 리턴타입을 기준과 다르게 처리한다는것을 명시
	@RequestMapping("/restful/before")
	public List<BoardVO> before() {
	
	//자바 객체를 xml 바꿔주는 뭔가(객체)가 있다.	
	//안된다는 이유는 객체가 없다는 뜻이다!!
	log.info("/restful/before");
	List<BoardVO> list = boardService.getList();
	
	return list;
	
	}
	
	
}
	



