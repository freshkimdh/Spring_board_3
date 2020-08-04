package edu.bit.board.vo;

import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter
public class ScoreVO {

	double kor;
	double eng;
	double math;
	
	
	public double getSum() {
		return kor + eng + math;
	}
	

	
	
}
