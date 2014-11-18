package main.java.com.plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@Column(name = "CUSTOMERID", unique = true, nullable = false)
	private Integer customerId;
	
	@Column(name = "BUSINESSENTITY")
	private String businessEntity;
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	@Column(name = "CUSTOMERTYPEID")
	private String customerTypeId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PARENTCUSTOMERID")
	private String parentCustomerId;
	@Column(name = "PRI_AREACODE")
	private String priAreaCode;
	@Column(name = "PRI_COUNTRYCODE")
	private String priCountryCode;
	@Column(name = "PRI_EXTENSION")
	private String priExtension;
	@Column(name = "PRI_NUMBER")
	private String priNumber;
	@Column(name = "SIC")
	private String sic;
	
	/*********************************/
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	/*********************************/

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the businessEntity
	 */
	public String getBusinessEntity() {
		return businessEntity;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param businessEntity the businessEntity to set
	 */
	public void setBusinessEntity(String businessEntity) {
		this.businessEntity = businessEntity;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the customerTypeId
	 */
	public String getCustomerTypeId() {
		return customerTypeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param customerTypeId the customerTypeId to set
	 */
	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the parentCustomerId
	 */
	public String getParentCustomerId() {
		return parentCustomerId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param parentCustomerId the parentCustomerId to set
	 */
	public void setParentCustomerId(String parentCustomerId) {
		this.parentCustomerId = parentCustomerId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the priAreaCode
	 */
	public String getPriAreaCode() {
		return priAreaCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param priAreaCode the priAreaCode to set
	 */
	public void setPriAreaCode(String priAreaCode) {
		this.priAreaCode = priAreaCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the priCountryCode
	 */
	public String getPriCountryCode() {
		return priCountryCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param priCountryCode the priCountryCode to set
	 */
	public void setPriCountryCode(String priCountryCode) {
		this.priCountryCode = priCountryCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the priExtension
	 */
	public String getPriExtension() {
		return priExtension;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param priExtension the priExtension to set
	 */
	public void setPriExtension(String priExtension) {
		this.priExtension = priExtension;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the priNumber
	 */
	public String getPriNumber() {
		return priNumber;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param priNumber the priNumber to set
	 */
	public void setPriNumber(String priNumber) {
		this.priNumber = priNumber;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the sic
	 */
	public String getSic() {
		return sic;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param sic the sic to set
	 */
	public void setSic(String sic) {
		this.sic = sic;
	}
	
	
}
