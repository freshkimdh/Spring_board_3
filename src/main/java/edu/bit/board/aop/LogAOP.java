package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {
	
	//Advice: Aspect Ŭ������ ����ִ� ���� ���  - ex) ������
	//JointPoint: advice �Լ��� ����Ǵ� �Լ�  - ex) ServiceImpl
	//proxy (�ڶ���)
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






