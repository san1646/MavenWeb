package main.java.com.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.plm.dao.CustomerTypeDao;
import main.java.com.plm.model.CustomerType;
import main.java.com.plm.service.CustomerTypeService;

@Service
@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService {

	@Autowired
	private CustomerTypeDao customerTypeDao;
	
	public List<CustomerType> getCustomerType() {
		// TODO Auto-generated method stub
		return customerTypeDao.getCustomerType();
	}

}
