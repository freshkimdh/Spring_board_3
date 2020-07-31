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

//spring v4.0 �������� (@Controller + @ResponseBody)
@Controller
@AllArgsConstructor
@Log4j
public class RestBoardSpring4BeforeController {
	
	private BoardService boardService;
	
	@ResponseBody // restful ���� ������̼��̸�, �޼ҵ��� ����Ÿ���� ���ذ� �ٸ��� ó���Ѵٴ°��� ���
	@RequestMapping("/restful/before")
	public List<BoardVO> before() {
	
	//�ڹ� ��ü�� xml �ٲ��ִ� ����(��ü)�� �ִ�.	
	//�ȵȴٴ� ������ ��ü�� ���ٴ� ���̴�!!
	log.info("/restful/before");
	List<BoardVO> list = boardService.getList();
	
	return list;
	
	}
	
	
}
	



