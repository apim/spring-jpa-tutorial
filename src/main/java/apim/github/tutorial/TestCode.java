package apim.github.tutorial;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		CustomerDAO dao = (CustomerDAO) ctx.getBean("customerDAO");
		dao.addCustomer(new Customer(50, "Sam", 5000));
		dao.addCustomer(new Customer(60, "Peter", 4000));
		List<Customer> list = dao.findCustomerByBalance(2000);
		for (Customer c : list) {
			System.out.println(c.getId() + ": " + c.getName());
		}
		ctx.close();
	}

}