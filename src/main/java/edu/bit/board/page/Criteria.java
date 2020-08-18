package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	
	private int pageNum; //페이지 번호
	private int amount; //한페이지당 몇개의 데이터를보여줄것인가?
	
	public Criteria() {
		this(1, 10); // 기본값 1페이지 10개로 지정
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
}


//변수가 어디에서 어떤 역활을 하는지 알아야 한다. (변수는 총 7개!!)
//자바는 해당 객체에 대한 값을 변경시키면서 하는것이 목적이다.
//
