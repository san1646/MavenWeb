package main.java.com.plm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMPLOYEEID")Integer employeeId;
	@Column(name = "ADDRESSLINE1")String addressLine1;
	@Column(name = "ADDRESSLINE2")String addressLine2;
	@Column(name = "CITY")String city;
	@Column(name = "COUNTRY")String country;
	@Column(name = "DATEOFBIRTH")String dateOfBirth;
	@Column(name = "DEPARTMENTID")Integer departmentId;
	@Column(name = "EMAIL")String email;
	@Column(name = "EMPENDDATE")String empEndDate;
	@Column(name = "EMPSTARTDATE")String empStartDate;
	@Column(name = "EMPTITLE")String empTitle;
	@Column(name = "ENDDATE")String endDate;
	@Column(name = "FIRSTNAME")String firstName;
	@Column(name = "LASTNAME")String lastName;
	@Column(name = "EMPLEVEL")String level;
	@Column(name = "MINIT")String mInit;
	@Column(name = "POSTALCODE")String postalCode;
	@Column(name = "PRI_AREACODE")String pri_AreaCode;
	@Column(name = "PRI_COUNTRYCODE")String pri_CountryCode;
	@Column(name = "PRI_EXTENSION")String pri_Extension;
	@Column(name = "PRI_NUMBER")String pri_Number;
	@Column(name = "PROVINCE")String province;
	@Column(name = "SEC_AREACODE")String sec_AreaCode;
	@Column(name = "SEC_COUNTRYCODE")String sec_CountryCode;
	@Column(name = "SEC_EXTENSION")String sec_Extension;
	@Column(name = "SEC_WORKNUMBER")String sec_WorkNumber;
	@Column(name = "SME")String sme;
	@Column(name = "STARTDATE")String startDate;
	@Column(name = "STATE")String state;
	@Column(name = "SUFFIX")String suffix;
	@Column(name = "SUPERVISOREMPID")Integer supervisorEmpId;
	@Column(name = "ZIPCODE")String zipCode;
	@Column(name = "ZIPCODEPLUS4")String zipCodePlus4;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
/*************************************************************************************************/
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
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
	 * @return the empEndDate
	 */
	public String getEmpEndDate() {
		return empEndDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param empEndDate the empEndDate to set
	 */
	public void setEmpEndDate(String empEndDate) {
		this.empEndDate = empEndDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the empStartDate
	 */
	public String getEmpStartDate() {
		return empStartDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param empStartDate the empStartDate to set
	 */
	public void setEmpStartDate(String empStartDate) {
		this.empStartDate = empStartDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the empTitle
	 */
	public String getEmpTitle() {
		return empTitle;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param empTitle the empTitle to set
	 */
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the mInit
	 */
	public String getmInit() {
		return mInit;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param mInit the mInit to set
	 */
	public void setmInit(String mInit) {
		this.mInit = mInit;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the pri_AreaCode
	 */
	public String getPri_AreaCode() {
		return pri_AreaCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param pri_AreaCode the pri_AreaCode to set
	 */
	public void setPri_AreaCode(String pri_AreaCode) {
		this.pri_AreaCode = pri_AreaCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the pri_CountryCode
	 */
	public String getPri_CountryCode() {
		return pri_CountryCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param pri_CountryCode the pri_CountryCode to set
	 */
	public void setPri_CountryCode(String pri_CountryCode) {
		this.pri_CountryCode = pri_CountryCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the pri_Extension
	 */
	public String getPri_Extension() {
		return pri_Extension;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param pri_Extension the pri_Extension to set
	 */
	public void setPri_Extension(String pri_Extension) {
		this.pri_Extension = pri_Extension;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the pri_Number
	 */
	public String getPri_Number() {
		return pri_Number;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param pri_Number the pri_Number to set
	 */
	public void setPri_Number(String pri_Number) {
		this.pri_Number = pri_Number;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the sec_AreaCode
	 */
	public String getSec_AreaCode() {
		return sec_AreaCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param sec_AreaCode the sec_AreaCode to set
	 */
	public void setSec_AreaCode(String sec_AreaCode) {
		this.sec_AreaCode = sec_AreaCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the sec_CountryCode
	 */
	public String getSec_CountryCode() {
		return sec_CountryCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param sec_CountryCode the sec_CountryCode to set
	 */
	public void setSec_CountryCode(String sec_CountryCode) {
		this.sec_CountryCode = sec_CountryCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the sec_Extension
	 */
	public String getSec_Extension() {
		return sec_Extension;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param sec_Extension the sec_Extension to set
	 */
	public void setSec_Extension(String sec_Extension) {
		this.sec_Extension = sec_Extension;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the sec_WorkNumber
	 */
	public String getSec_WorkNumber() {
		return sec_WorkNumber;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param sec_WorkNumber the sec_WorkNumber to set
	 */
	public void setSec_WorkNumber(String sec_WorkNumber) {
		this.sec_WorkNumber = sec_WorkNumber;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the sme
	 */
	public String getSme() {
		return sme;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param sme the sme to set
	 */
	public void setSme(String sme) {
		this.sme = sme;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the supervisorEmpId
	 */
	public Integer getSupervisorEmpId() {
		return supervisorEmpId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param supervisorEmpId the supervisorEmpId to set
	 */
	public void setSupervisorEmpId(Integer supervisorEmpId) {
		this.supervisorEmpId = supervisorEmpId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the zipCodePlus4
	 */
	public String getZipCodePlus4() {
		return zipCodePlus4;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param zipCodePlus4 the zipCodePlus4 to set
	 */
	public void setZipCodePlus4(String zipCodePlus4) {
		this.zipCodePlus4 = zipCodePlus4;
	}
	
}
