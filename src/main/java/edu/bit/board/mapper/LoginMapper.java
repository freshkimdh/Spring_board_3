package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;

public interface LoginMapper {
	
	//param의 값이 select 안으로 쏙쏙 들어간다.
	@Select("select * from users where username = #{username} and password = #{password}")
	public UserVO logInUser(@Param("username") String username, @Param("password") String password);

	


}
