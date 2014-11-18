package main.java.com.plm.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name="PROJ_EMP")
/*@AssociationOverrides({
	@AssociationOverride(name = "pk.project", 
		joinColumns = @JoinColumn(name = "PROJECTID")),
	@AssociationOverride(name = "pk.employee", 
		joinColumns = @JoinColumn(name = "EMPLOYEEID")) })*/
public class Proj_Emp {

	@EmbeddedId
	private Proj_EmpId proj_EmpId;
	
	private String endDate;
	private String startDate;
	
	/*******************************************************************************************/
	
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the proj_EmpId
	 */
	public Proj_EmpId getProj_EmpId() {
		return proj_EmpId;
	}
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param proj_EmpId the proj_EmpId to set
	 */
	public void setProj_EmpId(Proj_EmpId proj_EmpId) {
		this.proj_EmpId = proj_EmpId;
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
	
}
