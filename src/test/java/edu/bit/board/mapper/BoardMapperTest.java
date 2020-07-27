package edu.bit.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//�̳��� ���ؼ� datasource ������
@Log4j
public class BoardMapperTest {

	//���� 3���� ���(������, setter, �ʵ忡 ���̷�Ʈ)
	// ���̷�Ʈ ����� @Autowired
	
	//dao �׽�Ʈ�� ���ؼ��� Ŀ�ؼ�Ǯ�� DB �����ؾ��ϴµ�, root .xml�� �ִ�
	//dataSource, sqlSessionFactory(�̰��� Mybatis)
	
	//@Autowired �̷��� �ᵵ �ȴ�.
	//boardMapper�� ���� ���� �Լ��� ����
	//�ڵ����� boardMapper ������ ���Ѷ�
	@Setter(onMethod_ = @Autowired) 
	private BoardMapper boardMapper; //mapper�� DAO �̴�.
	
	@Test
	public void testBoardMapper() {
		log.info(boardMapper);
	} 
	
	@Test
	public void testBoardMapperList() {
		List<BoardVO> list = boardMapper.getList();
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getbContent());
			log.info(boardVO.getbName());
			log.info(boardVO.getbGroup());
		}		
	} 
}
