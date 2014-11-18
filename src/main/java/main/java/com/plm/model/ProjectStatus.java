package main.java.com.plm.model;

public class ProjectStatus {

	Integer projectId;
	int projectStatusId;
	
	public ProjectStatus() {
		// TODO Auto-generated constructor stub
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

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the projectStatusId
	 */
	public int getProjectStatusId() {
		return projectStatusId;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param projectStatusId the projectStatusId to set
	 */
	public void setProjectStatusId(int projectStatusId) {
		this.projectStatusId = projectStatusId;
	}

	
	
}
