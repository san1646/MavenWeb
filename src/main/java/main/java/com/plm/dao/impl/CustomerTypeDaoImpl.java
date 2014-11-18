package main.java.com.plm.dao.impl;

import java.util.List;
import main.java.com.plm.dao.CustomerTypeDao;
import main.java.com.plm.model.CustomerType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@org.springframework.transaction.annotation.Transactional
public class CustomerTypeDaoImpl implements CustomerTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerType> getCustomerType() {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().createQuery("from CustomerType");
		List<CustomerType> customerTypeList = (List<CustomerType>) query.list();
		return customerTypeList;
	}

}
