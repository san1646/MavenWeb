package main.java.com.plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERTYPE")
public class CustomerType {

	public CustomerType() {
		// TODO Auto-generated constructor stub
		this.customerTypeDescription = "No types";
	}
	
	@Id
	@Column(name = "CUSTOMERTYPEID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerTypeId;

	@Column(name = "CUSTOMERTYPEDESCRIPTION")
	private String customerTypeDescription;

	/*Getters and Setters*/
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the customerTypeId
	 */
	public Integer getCustomerTypeId() {
		return customerTypeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param customerTypeId the customerTypeId to set
	 */
	public void setCustomerTypeId(Integer customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the customerTypeDescription
	 */
	public String getCustomerTypeDescription() {
		return customerTypeDescription;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param customerTypeDescription the customerTypeDescription to set
	 */
	public void setCustomerTypeDescription(String customerTypeDescription) {
		this.customerTypeDescription = customerTypeDescription;
	}
	
}
