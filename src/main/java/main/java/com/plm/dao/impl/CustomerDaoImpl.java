package main.java.com.plm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.plm.dao.CustomerDao;
import main.java.com.plm.model.Customer;
import main.java.com.plm.model.ProjectKWBS;

@Repository
@org.springframework.transaction.annotation.Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Customer");
		List<Customer> customerList = (List<Customer>) query.list();

		return customerList;
	}
	
	public List<Customer> getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Customer where customerId = :customerId ");
		query.setParameter("customerId", customerId);
		List<Customer> customerList = (List<Customer>) query.list();
		
		return customerList;
	}

}
