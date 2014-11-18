package main.java.com.plm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectKWBSId implements Serializable{
	
	@Column(name = "KN_KNIGHTEDWBS_KNIGHTEDWBSID")
	Integer knightedWbsId;
	
	@Column(name = "PROJECT_PROJECTID")
	Integer projectId;
	
	public ProjectKWBSId() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProjectKWBSId(Integer knightedWbsId, Integer projectId) {
		super();
		this.knightedWbsId = knightedWbsId;
		this.projectId = projectId;
	}


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
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}
	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((knightedWbsId == null) ? 0 : knightedWbsId.hashCode());
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProjectKWBSId))
			return false;
		ProjectKWBSId other = (ProjectKWBSId) obj;
		if (knightedWbsId == null) {
			if (other.knightedWbsId != null)
				return false;
		} else if (!knightedWbsId.equals(other.knightedWbsId))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}
	
	
}