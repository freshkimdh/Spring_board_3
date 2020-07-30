package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	
	//@Before("within(edu.bit.board.service.*)")
		public void printLogging() {
			System.out.println("공통기능 - 프린트로그");

		}
}




