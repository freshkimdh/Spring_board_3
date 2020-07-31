package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect // ������̼��� ����ؼ� AOP ���� �ϴ� ���
public class LogAOP {
	
	
	//Ư�� �޼ҵ常 �����ϴ� ���
	@Pointcut("execution(* edu.bit.board..*.getList()")
	private void loggerPoint() {
		
	}
	
	
	
	//Advice: Aspect Ŭ������ ����ִ� ���� ���  - ex) ������
	//JointPoint: advice �Լ��� ����Ǵ� �Լ�  - ex) ServiceImpl
	//proxy (�ڶ���)
	
	//@Around("within(edu.bit.board..*)") //������̼��� ����ؼ� AOP ����
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable { // ������
			
		
		//signatureStr �̰��� BoardContorller�� proxy�� ������ �Դ�.
		String signatureStr = joinpoint.getSignature().toShortString();
			
		System.out.println(signatureStr + "is start.");
			
			long st = System.currentTimeMillis();
			
		try {
			//list() ���� �ٽɱ��
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
				
			long et = System.currentTimeMillis();
				
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "����ð�: " + (et - st));
		}
				
	}
		

		
}





