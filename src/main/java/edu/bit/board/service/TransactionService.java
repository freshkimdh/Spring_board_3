package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TransactionService {
	
	
	private BoardMapper boardMapper;
	
	   public void transactionTest1() {
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("트랜1");
		      boardVO.setbName("트랜1");
		      boardVO.setbTitle("트랜1");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      boardVO.setbContent("트랜2");
		      boardVO.setbName("트랜2");
		      boardVO.setbTitle("트랜2");
		      
		      boardMapper.insertBoard(boardVO);
		      
		   }
	   
	   public void transactionTest2() {
		     
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("트랜1");
		      boardVO.setbName("트랜1");
		      boardVO.setbTitle("트랜1");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      boardVO.setbContent("트랜2");
		      boardVO.setbName("트랜2");
		      boardVO.setbTitle("트랜2");
		      
		      boardVO = null;
		      
		      boardMapper.insertBoard(boardVO);
		      
		   }
	   
	   
	   @Transactional
	   public void transactionTest3() {
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("트랜1");
		      boardVO.setbName("트랜1");
		      boardVO.setbTitle("트랜1");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      boardVO.setbContent("트랜2");
		      boardVO.setbName("트랜2");
		      boardVO.setbTitle("트랜2");
		      
		      boardVO = null;
		      
		      boardMapper.insertBoard(boardVO);
		      
		   }
	   
	   
	   @Transactional
	   public void transactionTest4() {
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("트랜4");
		      boardVO.setbName("트랜4");
		      boardVO.setbTitle("트랜4");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      throw new RuntimeException("RuntimeException for rollback");
		      
		      
		   }
	   
	   
	   @Transactional
	   public void transactionTest5() throws IOException{
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("트랜5");
		      boardVO.setbName("트랜5");
		      boardVO.setbTitle("트랜5");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      throw new IOException("IOLExcption for rollback");
		      
		      
		   }
	   
	   
	   //롤백 시키는 방법
	   //@Transactional의 롤백포 옵션을 이용하면 롤백이 되는 클래스를 지정 가능함.
	   //익셉션 예외로 콜백을 하려면 다음과 같이 지정 한다
	   //@Transactional(rollbackFor = Exception.class)
	   //여러개의 예외를 지정할 수도 있다.
	   //@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	   @Transactional(rollbackFor = Exception.class) // 다형성 적용
	   public void transactionTest6() throws IOException{
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("트랜6");
		      boardVO.setbName("트랜6");
		      boardVO.setbTitle("트랜6");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      throw new IOException("IOExcption for rollback");
		      
		      
		   }

	
}
