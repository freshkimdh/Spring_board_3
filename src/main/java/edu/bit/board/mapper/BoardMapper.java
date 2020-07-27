package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	
	//�ڼ��� �����ؾ��ϴµ�, resource ���Ͽ��� xml �� ���ؼ� �����Ѵ�.
	//mapper �� �������̽��̰�, �������̽��� �ڼ��� ����
	//List<BoardVO> �������� dao�� �Ἥ 3 ������ ������, 
	//Mybatis�� �̿��ؼ� xml���� ������ ���ش�
	//Mybatis�� xml�� �߿��ϴ�, ���� �˾ƾ� �Ѵ�!!
	//Mybatis�� 3������ ������ �ͼ� ���� ���ش�
	
	//getList() �̰Ŷ� xml�� id�� �Ȱ��ƾ� �Ѵ�. (�Լ���)
	//"List<BoardVO>" �̰Ŷ� xml�� resultType="edu.bit.board.vo.BoardVO" �̰Ŷ� ��ġ (���׸��κ�) 
	public List<BoardVO> getList();

	public BoardVO read(int bno);
	
	@Delete("Delete from mvc_board where bid = #{bno}")
	public void delete(int bno);

	public void insertBoard(BoardVO boardvo);
	
	//@Param("boardVO")
	//������ �Ķ���͸� �������� �Ķ���ͷ� �ϴ� ��?
	//boardVO �� ��ü�� �����͸� ��Ƽ� �ѱ��
	public void updateShape(BoardVO boardVO);

	public void insertReply(BoardVO boardVO);

	public void updateModify(BoardVO boardVO);
	
	public void addUphit(int bno);

}
