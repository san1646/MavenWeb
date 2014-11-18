package main.java.com.plm.model;

import main.java.com.plm.dao.ContactDao;
import main.java.com.plm.form.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SimpleMain {

	/*@Autowired
	private static ProjectManager projectManagerImpl;*/
	
	
	public static void main(String args[]){
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernateConfig.xml");
		ProjectManager projectManager = (ProjectManagerImpl) applicationContext.getBean("projectManagerImpl");*/
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ContactDao contactDao = (ContactDao)applicationContext.getBean("contactDao");
		Contact contact = new Contact("sad","das","s@b", "513" );
		contactDao.insert(contact);
		
		System.out.println("Contact inserted!");
		
	}


	
}
