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
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//이넘을 통해서 datasource 가져옴
@Log4j
public class BoardMapperTest {

	//주입 3가지 방식(생성자, setter, 필드에 다이렉트)
	// 다이렉트 방식은 @Autowired
	
	//dao 테스트를 위해서는 커넥션풀로 DB 접속해야하는데, root .xml에 있는
	//dataSource, sqlSessionFactory(이것이 Mybatis)
	
	//@Autowired 이렇게 써도 된다.
	//boardMapper에 대한 셋터 함수를 생성
	//자동으로 boardMapper 주입을 시켜라
	@Setter(onMethod_ = @Autowired) 
	private BoardMapper boardMapper; //mapper는 DAO 이다.
	
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
