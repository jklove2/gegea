package a.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import a.action.UserAction;

public class Atest {
	@Test
	public void testSave() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserAction action = (UserAction) ac.getBean("userAction");
	
	   action.execute();
	}

}
