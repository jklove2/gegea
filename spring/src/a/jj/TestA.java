package a.jj;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {
	@Test
	public void testAa() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("a/jj/beans.xml");
		User user1 = (User) ac.getBean("user1");
		User user2 = (User) ac.getBean("user1");
		User user3 = (User) ac.getBean("user3");
		System.out.println(user1 == user3);

		System.out.println(user1 == user2);
	}

}
