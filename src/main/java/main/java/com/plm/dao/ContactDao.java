package main.java.com.plm.dao;

import main.java.com.plm.form.Contact;

public interface ContactDao {

	public void insert(Contact contact);
	public Contact findByCustomerId(int custId);
}
