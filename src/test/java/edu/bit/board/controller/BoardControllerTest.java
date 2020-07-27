package edu.bit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//스프링에 있는 객체를 테스트를 하려면 기존 방식과 다르다
//스프링 IOC 컨테이너에 있는 객체가 있는지 확인 하는 것이므로, 직접 불러와야 한다.
//톰갯 구동이 필요하지만, 구동 안하고 아래 파일을 읽어서 확인 하는것이다.  즉,IOC 컨테이너 안에 있는지 확인하는 것.
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTest {
	
	@Setter(onMethod_ = @Autowired)
	
	//이 객체는 어디서 가지고 온다?
	//스프링 ioc 컨테이너에서 가지고 온다. 
	//제네릭 어플리케이션 초기 예제를 보면 쉽게 알 수 있다.
	//이것이 ioc 컨테이너!! 언제 생성? 서블릿
	//이 안에 controller를 가지고 있고, 그 객체는 어디에? ioc 컨테이너에 있어서 불러온다.
	//우리 눈에는 안보인다 왜? dispater 서블릿 생성 될때 알아서 생성 되니깐
	private WebApplicationContext ctx; // 서블릿, root 둘다 가지고 있는다
	
	//테스트 할 수 있는 함수, 기능을 가지고 있다.
	//이것이 서버 역활을 한다는 의미!!	
	
	//MockMvc란?
	//실제 객체와 비슷하지만 테스트에 필요한 기능만 가지는 가짜 객체를 만들어서
	//애플리케이션 서버에 배포하지 않고도 스프링 MVC 동작을 재현할 수 있는 클래스를 의미.
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/*
	 @GetMapping("/list")
	 public void list(Model model) {	
		 log.info("list");
		 model.addAttribute("list", service.getList());	
	 }*/
	
	@Test
	public void testList() throws Exception {
		 mockMvc.perform(get("/list"))
		 .andExpect(status().isOk())//응답 검증
		 .andDo(print())
        .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	}

}

//test를 하려면 "/list"를 받아내야하는데,
//받아내는 주체는 톰캣에서 url 치고 들어오는 것을 받아내야 하는데
//결국 위를 테스트 하려면 웹서버를 돌려야한다.
//웹서버를 돌려야하는 뭐가 있어야 하는데
//별도로 하나 만들었다. mock 





