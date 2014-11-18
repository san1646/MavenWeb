package main.java.com.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.plm.dao.CustomerDao;
import main.java.com.plm.dao.TechnologyDao;
import main.java.com.plm.model.Customer;
import main.java.com.plm.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerDao.getCustomer();
	}

	public List<Customer> getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(customerId);
	}

}
