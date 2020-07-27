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

//�������� �ִ� ��ü�� �׽�Ʈ�� �Ϸ��� ���� ��İ� �ٸ���
//������ IOC �����̳ʿ� �ִ� ��ü�� �ִ��� Ȯ�� �ϴ� ���̹Ƿ�, ���� �ҷ��;� �Ѵ�.
//�谹 ������ �ʿ�������, ���� ���ϰ� �Ʒ� ������ �о Ȯ�� �ϴ°��̴�.  ��,IOC �����̳� �ȿ� �ִ��� Ȯ���ϴ� ��.
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTest {
	
	@Setter(onMethod_ = @Autowired)
	
	//�� ��ü�� ��� ������ �´�?
	//������ ioc �����̳ʿ��� ������ �´�. 
	//���׸� ���ø����̼� �ʱ� ������ ���� ���� �� �� �ִ�.
	//�̰��� ioc �����̳�!! ���� ����? ����
	//�� �ȿ� controller�� ������ �ְ�, �� ��ü�� ���? ioc �����̳ʿ� �־ �ҷ��´�.
	//�츮 ������ �Ⱥ��δ� ��? dispater ���� ���� �ɶ� �˾Ƽ� ���� �Ǵϱ�
	private WebApplicationContext ctx; // ����, root �Ѵ� ������ �ִ´�
	
	//�׽�Ʈ �� �� �ִ� �Լ�, ����� ������ �ִ�.
	//�̰��� ���� ��Ȱ�� �Ѵٴ� �ǹ�!!	
	
	//MockMvc��?
	//���� ��ü�� ��������� �׽�Ʈ�� �ʿ��� ��ɸ� ������ ��¥ ��ü�� ����
	//���ø����̼� ������ �������� �ʰ� ������ MVC ������ ������ �� �ִ� Ŭ������ �ǹ�.
	
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
		 .andExpect(status().isOk())//���� ����
		 .andDo(print())
        .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	}

}

//test�� �Ϸ��� "/list"�� �޾Ƴ����ϴµ�,
//�޾Ƴ��� ��ü�� ��Ĺ���� url ġ�� ������ ���� �޾Ƴ��� �ϴµ�
//�ᱹ ���� �׽�Ʈ �Ϸ��� �������� �������Ѵ�.
//�������� �������ϴ� ���� �־�� �ϴµ�
//������ �ϳ� �������. mock 





