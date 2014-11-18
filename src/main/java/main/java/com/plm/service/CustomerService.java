package main.java.com.plm.service;

import java.util.List;
import main.java.com.plm.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

	List<Customer> getCustomer();
	List<Customer> getCustomer(Integer customerId);
}
