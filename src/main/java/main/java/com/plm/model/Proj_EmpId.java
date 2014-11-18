package main.java.com.plm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Proj_EmpId implements Serializable {

	@Column(name = "EMPLOYEE_EMPLOYEEID")
	Integer employee_employeeId;
	
	@Column(name = "PROJECT_PROJECTID")
	Integer project_projectId;
	
	public Proj_EmpId() {
		// TODO Auto-generated constructor stub
	}

	public Proj_EmpId(Integer employee_employeeId, Integer project_projectId) {
		super();
		this.employee_employeeId = employee_employeeId;
		this.project_projectId = project_projectId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the employee_employeeId
	 */
	public Integer getEmployee_employeeId() {
		return employee_employeeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param employee_employeeId the employee_employeeId to set
	 */
	public void setEmployee_employeeId(Integer employee_employeeId) {
		this.employee_employeeId = employee_employeeId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the project_projectId
	 */
	public Integer getProject_projectId() {
		return project_projectId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param project_projectId the project_projectId to set
	 */
	public void setProject_projectId(Integer project_projectId) {
		this.project_projectId = project_projectId;
	}
	
	/*******************************************************************************/
	
}
