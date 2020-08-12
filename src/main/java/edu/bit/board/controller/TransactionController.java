package edu.bit.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.service.TransactionService;
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
public class TransactionController {
	
	private TransactionService transactionService;
	
	
	//레스트풀로 넘기는 방식으로 하자.
	//레스트풀 관련 어노테이션 (RestFul)
	@GetMapping("/tran/{num}")
	public void transation(@PathVariable("num") int num) throws IOException {
		if(num==1) {
			log.info("transionTest1 테스트");
			
			transactionService.transactionTest1();
		} else if (num==2) {
			log.info("transionTest2 테스트");
			
			transactionService.transactionTest2();
		} else if (num==3) {
			log.info("transionTest3 테스트");
			
			transactionService.transactionTest3();
		} else if (num==4) {
			log.info("transionTest4 테스트");
			
			transactionService.transactionTest4();
		} else if (num==5) {
			log.info("transionTest5 테스트");
			
			transactionService.transactionTest5();
		} else if (num==6) {
			log.info("transionTest6 테스트");
			
			transactionService.transactionTest6();
		}
		
		
	}
	

	
	
	
	
	
}
	





