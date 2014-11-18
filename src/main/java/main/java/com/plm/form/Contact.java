package main.java.com.plm.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table(name="CONTACTS")
public class Contact {
     
	public Contact(/*Integer id, */String firstname, String lastname, String email, String telephone) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.firstname = firstname;
		/*this.id = id;*/
		this.lastname = lastname;
		this.telephone = telephone;
		
	}
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    //@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTACT_ID")
    //@SequenceGenerator(name="SEQ_CONTACT_ID", sequenceName="SEQ_CONTACT_ID",allocationSize=1)
    //@SequenceGenerator(name="SEQ_CONTACT_ID", sequenceName="SEQ_CONTACT_ID",allocationSize=1)    
    private Integer id;
     
    @Column(name="FIRSTNAME")
    private String firstname;
 
    @Column(name="LASTNAME")
    private String lastname;
 
    @Column(name="EMAIL")
    private String email;
     
    @Column(name="TELEPHONE")
    private String telephone;
     
     
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}

