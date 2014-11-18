package main.java.com.plm.dao;

import java.util.List;
import main.java.com.plm.model.Customer;

public interface CustomerDao {
	List<Customer> getCustomer();
	
	List<Customer> getCustomer(Integer customerId);
}
