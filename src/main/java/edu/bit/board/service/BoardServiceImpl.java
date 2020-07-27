package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j 
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	
	private BoardMapper mapper; // DAO 레포지토리
	
	//List 인터페이스를 사용하여, 상황에 맞는 다형성 적용 (ArrayList, LinkedList)
	public List<BoardVO> getList() {
		log.info("getList........"); 
		
		return mapper.getList();
	}

	@Override
	public BoardVO get(int bno) {
		
		log.info("get........");
		
		BoardVO boardVO = mapper.read(bno);
						mapper.addUphit(bno);
		
		return boardVO;
				
	}

	@Override
	public void remove(int bno) {
		
		log.info("remove........");
		
		mapper.delete(bno);
		
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		
		log.info("write........");
		
		mapper.insertBoard(boardVO);
	}

	@Override
	public void writeReply(BoardVO boardVO) {
		
		log.info("writeReply........");
		
		
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);
		//mapper.updateShape(boardVO);
		
	}

	@Override
	public void modify(BoardVO boardVO) {
		
		log.info("modify........");
		
		mapper.updateModify(boardVO);
		
	}

	
}






