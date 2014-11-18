package main.java.com.plm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.plm.dao.ContactDao;
import main.java.com.plm.form.Contact;
import main.java.com.plm.service.ContactService;

@Service
@org.springframework.transaction.annotation.Transactional
public class ContactServiceImpl implements ContactService{

	@Autowired
    private ContactDao contactDao;
	
	@org.springframework.transaction.annotation.Transactional
	public void insert(Contact contact) {
		// TODO Auto-generated method stub
		contactDao.insert(contact);
	}
	
}
