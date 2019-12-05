package apim.github.tutorial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addCustomer(Customer c) {
		entityManager.persist(c);
	}

	@Transactional
	public List<Customer> getAllCustomers() {
		return entityManager.createQuery("from Customer").getResultList();
	}

	@Transactional
	public List<Customer> findCustomerByBalance(double amt) {
		return (List<Customer>) entityManager.createQuery("select c from Customer as c where c.balance >= " + amt)
				.getResultList();
	}

}
