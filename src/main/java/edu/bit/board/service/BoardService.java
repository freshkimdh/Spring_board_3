package edu.bit.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> getList();

	public BoardVO get(int bno);

	@Delete("Delete from mvc_board where bid = #{bno}")
	public int remove(int bno);

	public void writeBoard(BoardVO boardVO);

	public void writeReply(BoardVO boardVO);

	public void modify(BoardVO boardVO);
	
	//∆‰¿Ã¬° √≥∏Æ
	public int getTotal(Criteria cri);
	
	public List<BoardVO> getList(Criteria criteria);
	
}
