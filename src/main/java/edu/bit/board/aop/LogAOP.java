package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect // 어노테이션을 사용해서 AOP 지정 하는 방법
public class LogAOP {
	
	
	//특정 메소드만 실행하는 방법
	@Pointcut("execution(* edu.bit.board..*.getList()")
	private void loggerPoint() {
		
	}
	
	
	
	//Advice: Aspect 클래스에 들어있는 공통 기능  - ex) 공통기능
	//JointPoint: advice 함수가 적용되는 함수  - ex) ServiceImpl
	//proxy (쁘라찌)
	
	//@Around("within(edu.bit.board..*)") //어노테이션을 사용해서 AOP 지정
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable { // 공통기능
			
		
		//signatureStr 이것은 BoardContorller을 proxy로 가지고 왔다.
		String signatureStr = joinpoint.getSignature().toShortString();
			
		System.out.println(signatureStr + "is start.");
			
			long st = System.currentTimeMillis();
			
		try {
			//list() 실행 핵심기능
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
				
			long et = System.currentTimeMillis();
				
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "경과시간: " + (et - st));
		}
				
	}
		

		
}






