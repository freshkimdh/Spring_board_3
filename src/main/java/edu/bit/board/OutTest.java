package edu.bit.board;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.board.aop.AopTest;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
public class OutTest {
	
	
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		log.info("Hello world");

	}

}
