package main.java.com.plm.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_KWBS")
public class ProjectKWBS implements Serializable{

	
		@EmbeddedId
		public ProjectKWBSId projectKWBSId;
		
		@Column(name = "HOURS")
		private String hours;
		
		@Column(name = "RATE")
		private String rate;

		@Column(name = "NOTEDESCRIPTION")
		private String noteDescription;
		
		@Column(name = "notetime")
		private String timeStamp;
		
		@Column(name = "USERID")
		private String userId;
		
		
		public ProjectKWBS() {
			// TODO Auto-generated constructor stub
		}
		
		
		/*Setters and Getters*/

		public ProjectKWBS(ProjectKWBSId projectKWBSId, String hours,
				String rate, String noteDescription, String timeStamp,
				String userId) {
			super();
			this.projectKWBSId = projectKWBSId;
			this.hours = hours;
			this.rate = rate;
			this.noteDescription = noteDescription;
			this.timeStamp = timeStamp;
			this.userId = userId;
		}


		/** PLM 2013
			@Author Sanket Bharaswadkar
		 * @return the projectKWBSId
		 */
		public ProjectKWBSId getProjectKWBSId() {
			return projectKWBSId;
		}

		/** PLM 2013
			@Author Sanket Bharaswadkar
		 * @param projectKWBSId the projectKWBSId to set
		 */
		public void setProjectKWBSId(ProjectKWBSId projectKWBSId) {
			this.projectKWBSId = projectKWBSId;
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
		 * @return the timeStamp
		 */
		public String getTimeStamp() {
			return timeStamp;
		}

		/** PLM 2013
			@Author Sanket Bharaswadkar
		 * @param timeStamp the timeStamp to set
		 */
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
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
		
	
}
