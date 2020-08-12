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
		      boardVO.setbContent("Ʈ��1");
		      boardVO.setbName("Ʈ��1");
		      boardVO.setbTitle("Ʈ��1");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      boardVO.setbContent("Ʈ��2");
		      boardVO.setbName("Ʈ��2");
		      boardVO.setbTitle("Ʈ��2");
		      
		      boardMapper.insertBoard(boardVO);
		      
		   }
	   
	   public void transactionTest2() {
		     
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("Ʈ��1");
		      boardVO.setbName("Ʈ��1");
		      boardVO.setbTitle("Ʈ��1");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      boardVO.setbContent("Ʈ��2");
		      boardVO.setbName("Ʈ��2");
		      boardVO.setbTitle("Ʈ��2");
		      
		      boardVO = null;
		      
		      boardMapper.insertBoard(boardVO);
		      
		   }
	   
	   
	   @Transactional
	   public void transactionTest3() {
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("Ʈ��1");
		      boardVO.setbName("Ʈ��1");
		      boardVO.setbTitle("Ʈ��1");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      boardVO.setbContent("Ʈ��2");
		      boardVO.setbName("Ʈ��2");
		      boardVO.setbTitle("Ʈ��2");
		      
		      boardVO = null;
		      
		      boardMapper.insertBoard(boardVO);
		      
		   }
	   
	   
	   @Transactional
	   public void transactionTest4() {
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("Ʈ��4");
		      boardVO.setbName("Ʈ��4");
		      boardVO.setbTitle("Ʈ��4");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      throw new RuntimeException("RuntimeException for rollback");
		      
		      
		   }
	   
	   
	   @Transactional
	   public void transactionTest5() throws IOException{
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("Ʈ��5");
		      boardVO.setbName("Ʈ��5");
		      boardVO.setbTitle("Ʈ��5");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      throw new IOException("IOLExcption for rollback");
		      
		      
		   }
	   
	   
	   //�ѹ� ��Ű�� ���
	   //@Transactional�� �ѹ��� �ɼ��� �̿��ϸ� �ѹ��� �Ǵ� Ŭ������ ���� ������.
	   //�ͼ��� ���ܷ� �ݹ��� �Ϸ��� ������ ���� ���� �Ѵ�
	   //@Transactional(rollbackFor = Exception.class)
	   //�������� ���ܸ� ������ ���� �ִ�.
	   //@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	   @Transactional(rollbackFor = Exception.class) // ������ ����
	   public void transactionTest6() throws IOException{
		      
		      
		      BoardVO boardVO = new BoardVO();
		      boardVO.setbContent("Ʈ��6");
		      boardVO.setbName("Ʈ��6");
		      boardVO.setbTitle("Ʈ��6");
		      
		      boardMapper.insertBoard(boardVO);
		      
		      throw new IOException("IOExcption for rollback");
		      
		      
		   }

	
}
