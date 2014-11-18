package main.java.com.plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Kn_KnightedWbsComplete")
public class KnightedWbsComplete {

	@Id
	@Column(name="KNIGHTEDID")
	Integer knightedId;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="TASKNAME")
	String taskName;
	
	@Column(name="TASKNUMBER", unique=true, nullable=false)
	String taskNumber;

	
	/* Getter and setters*/
	
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the knightedId
	 */
	public Integer getKnightedId() {
		return knightedId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param knightedId the knightedId to set
	 */
	public void setKnightedId(Integer knightedId) {
		this.knightedId = knightedId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the taskNumber
	 */
	public String getTaskNumber() {
		return taskNumber;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param taskNumber the taskNumber to set
	 */
	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}
	
	/* Getter and setters*/
	
}
