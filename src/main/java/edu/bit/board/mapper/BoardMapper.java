package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	
	//자손이 구현해야하는데, resource 파일에서 xml 을 통해서 구현한다.
	//mapper 는 인터페이스이고, 인터페이스는 자손이 구현
	//List<BoardVO> 예전에는 dao를 써서 3 대장을 썼지만, 
	//Mybatis를 이용해서 xml에서 설정을 해준다
	//Mybatis용 xml은 중요하니, 많이 알아야 한다!!
	//Mybatis가 3대장을 데리고 와서 구현 해준다
	
	//getList() 이거랑 xml의 id랑 똑같아야 한다. (함수명)
	//"List<BoardVO>" 이거랑 xml의 resultType="edu.bit.board.vo.BoardVO" 이거랑 일치 (제네릭부분) 
	public List<BoardVO> getList();

	public BoardVO read(int bno);
	
	@Delete("Delete from mvc_board where bid = #{bno}")
	public void delete(int bno);

	public void insertBoard(BoardVO boardvo);
	
	//@Param("boardVO")
	//오른쪽 파라미터를 왼쪽으로 파라미터로 하는 것?
	//boardVO 이 객체에 데이터를 담아서 넘긴다
	public void updateShape(BoardVO boardVO);

	public void insertReply(BoardVO boardVO);

	public void updateModify(BoardVO boardVO);
	
	public void addUphit(int bno);

}
