package main.java.com.plm.dao.impl;

import main.java.com.plm.dao.ContactDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.plm.form.Contact;

@Repository
@org.springframework.transaction.annotation.Transactional
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Contact contact) {
		getCurrentSession().save(contact);		
	}
	/*public void insert(Contact contact){
 
		String sql = "INSERT INTO CONTACTS (ID, FIRSTNAME, LASTNAME, TELEPHONE, EMAIL, CREATED) VALUES ('6', 'sad', 'das', '1233', 'sa@sd', TO_TIMESTAMP('06-AUG-13 12.00.46.768000000 PM', 'DD-MON-RR HH.MI.SSXFF AM'))";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}*/

	public Contact findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

}
