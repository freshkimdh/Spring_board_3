package edu.bit.board.service;



import org.springframework.stereotype.Service;
import edu.bit.board.mapper.LoginMapper;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LoginService  {
	
	
	LoginMapper logInMapper;
	
	public UserVO logInUser(String id, String pw) {
		return logInMapper.logInUser(id, pw);
	}


	
}






