package main.java.com.plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "KN_KNIGHTEDWBS")
public class KnightedWBSTechnology {
	
	public KnightedWBSTechnology() {
		// TODO Auto-generated constructor stub
	}
	
	@Transient
	public String noteDescription;
	
	@Transient
	public String userId;
	
	@Transient
	public String rate;
	
	
	public KnightedWBSTechnology(Integer knightedWbsId, String taskNumber,
			String hours, String noteDescription) {
		super();
		this.knightedWbsId = knightedWbsId;
		this.taskNumber = taskNumber;
		this.hours = hours;
		
		/*Transient */
		this.noteDescription = noteDescription;
	}



	@Id
	@Column(name = "KNIGHTEDWBSID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //, generator = "SEQ_KNIGHTEDWBSID")
	/*@SequenceGenerator(name = "SEQ_KNIGHTEDWBSID", sequenceName = "SEQ_KNIGHTEDWBSID", allocationSize = 1)*/
	@NotNull
	private Integer knightedWbsId;
	
	@Column(name = "TASKNUMBER", unique = true)	
	@NotNull
	private String taskNumber;
	
	@Column(name = "HOURS")
	@NumberFormat(style=Style.NUMBER)
	@NotNull
	@Min(value = 0)
	@Max(value = 100, message = "maximum value is 100 yo")
	private String hours;

	@Column(name = "TASKNAME")
	private String taskName;
	/*Setters and Getters*/
	
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the knightedWbsId
	 */
	public Integer getKnightedWbsId() {
		return knightedWbsId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param knightedWbsId the knightedWbsId to set
	 */
	public void setKnightedWbsId(Integer knightedWbsId) {
		this.knightedWbsId = knightedWbsId;
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
	
	
	//Overriding equals()
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == this){return true;}
		
		if(obj == null){return false;}
		
		KnightedWBSTechnology k = (KnightedWBSTechnology) obj;
		if(k.getTaskNumber().equalsIgnoreCase(this.getTaskNumber())	){ 
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
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

	/*Added on 11/12/13 - This will be used to tie up the project WBS to the Knighted WBS.
	 * It will help in synchronizing the notes for each line item in the View (createTechnology)*/ 
	
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the noteDescription
	 */
	public String getNoteDescription() {
		return noteDescription;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param noteDescription the noteDescription to set
	 */
	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
	
}
