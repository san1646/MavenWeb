package main.java.com.plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MDKNIGHTEDWBSRATE")
public class KnightedWBSRate {

	@Id
	@Column(name = "TASKNUMBER", unique = true, nullable = false)
	private String taskNumber;
	
	@Column(name = "RATE")	
	private String rate;
	
	@Column(name = "TASKNAME")
	private String taskName;
	
	@Column(name = "DESCRIPTION")
	private String description;

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

public KnightedWBSRate() {
		// TODO Auto-generated constructor stub
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

	@Override
	public boolean equals(Object object) {
	    if (!(object instanceof KnightedWBSRate)) {
	        return false;
	    }
	    KnightedWBSRate knightedWBSRate = (KnightedWBSRate) object;
	    // Custom equality check here.
	    if(!knightedWBSRate.taskNumber.equals(this.taskNumber)) {
	    	return false; 
	    	} 
	    else{
	    	if(knightedWBSRate.taskName!=null && knightedWBSRate.description!=null && knightedWBSRate.rate!=null
	    			&& this.taskName!=null && this.description!=null && this.rate!=null ){
	    		return knightedWBSRate.taskName.equals(this.taskName)
	    		&& knightedWBSRate.description.equals(this.description)
	    		&& knightedWBSRate.rate.equals(this.rate);
	    	}
	    	else {return false;}
	    	
	    }
	    		
	    
	}

}
