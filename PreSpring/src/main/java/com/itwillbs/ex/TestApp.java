package com.itwillbs.ex;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class TestApp {

	public static void main(String[] args) {
		
		// "안녕!, 아이티윌" 메세지 출력
		
//		System.out.println("안녕!, 아이티윌");
//		직접 만들어서 출력할 수 있음
		
		MessageBean mb = new MessageBean();
		mb.sayHello("아이티윌");
	
		// static 인스턴스 생성없이도 사용 가능! 
//		MessageBean.sayHello("아이티윌2");
		
		// 프레임워크 사용해서 출력
		// => MessageBean 객체 생성, 기능 sayHello 호출
		// static 주석 처리 후 생각 해보기
		
		// 있는 거 쓰려면 객체 생성 해야 함
		// => TestApp 클래스(나)는 MessageBean 클래스(객체)를 필요로 한다.
		// => TestApp 클래스(나)는 MessageBean 클래스(객체)를 의존하고 있다.
		//				[의존관계]
		
		// 메세지 출력
//		MsgBeanImpl mbi = new MsgBeanImpl(); // (강한결합)
//		mbi.sayHello("아이티윌");
		
		MsgBean mbi = new MsgBeanImpl(); // (약한결합(1)) 거리가 있다고 했을 때
		mbi.sayHello("아이티윌"); // -> 자식 MsgBeanImpl
	
		// => 어노테이션, 애노테이션을 사용한 처리
		// 외부 파일(xml)에 있는 객체 정보를 가져오기 (스프링과 연결)
		// 메세지 출력 (약한결합(2) - 의존관계 주입) 앞으로 활용할 형태의 모습
		BeanFactory fac = new XmlBeanFactory(new FileSystemResource("springBeans.xml"));
		
		// 메세지 출력에 필요한	
		// 객체 정보를 가져오기 
		fac.getBean("msgBean"); // springBeans.xml 에 있는 bean id 입력
		
//		MsgBean mb2 = (MsgBean) fac.getBean("msgBean");
//		mb2.sayHello("ITWILL");
		
		MsgBean mb2 = fac.getBean("msgBean", MsgBean.class);
		mb2.sayHello("ㅇㅇㅇ");
	}

}
