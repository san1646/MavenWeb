package main.java.com.plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROJ_KWBS")
public class ProjectKnightedWBS {

	/*HOURS
	KN_KNIGHTEDWBS_ID
	PROJECT_PROJECTID
	RATE*/
	
	
	public ProjectKnightedWBS() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProjectKnightedWBS(String hours, String knightedWbsId, String rate,
			String projectId) {
		super();
		this.hours = hours;
		this.knightedWbsId = knightedWbsId;
		this.rate = rate;
		this.projectId = projectId;
	}

	@Id
	@Column(name = "KN_KNIGHTEDWBS_ID")
	private String knightedWbsId;
	
	@Column(name = "HOURS")
	private String hours;
	
	@Column(name = "RATE")
	private String rate;
	
	@Column(name = "PROJECT_PROJECTID")
	private String projectId;

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the hours
	 */
	public String getHours() {
		return hours;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param hours the hours to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the knightedWbsId
	 */
	public String getKnightedWbsId() {
		return knightedWbsId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param knightedWbsId the knightedWbsId to set
	 */
	public void setKnightedWbsId(String knightedWbsId) {
		this.knightedWbsId = knightedWbsId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
