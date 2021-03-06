package edu.bit.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@AllArgsConstructor
@Log4j
@Controller
public class LoginController {
   
   private LoginService loginservice;
   
   @GetMapping("/")
   public String home() {
      log.info("home");
      return "login";
   }
   
   
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception{
      
      log.info("post login");
      
      HttpSession session = req.getSession(); //4가지 영역 중에 세션으로 저장한다.
      
      String id = req.getParameter("id");
      String pw = req.getParameter("pw");
      
      UserVO login = loginservice.logInUser(id,pw);
      
      
      if(login == null) {
         session.setAttribute("user", null);
         rttr.addFlashAttribute("msg",false);
      }else {
         session.setAttribute("user", login);
      }
         return "redirect:/";          
         
   }
   
   
   @RequestMapping(value = "/logout")
   public String logout(HttpSession session) throws Exception{
	   
	   log.info("/member/logout");
	      
	   //invalidate() GC에게 이거는 메모리를 날리라는 대상이라고 알려주는 것!
	   //session.delete() 이거는 메모리에 남아있는 상태
	   session.invalidate();
	   
	   return "redirect:/";
   }
   
   
   
      
}
   
