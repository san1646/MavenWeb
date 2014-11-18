package main.java.com.plm.form;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import main.java.com.plm.model.KnightedWBSTechnology;
import main.java.com.plm.model.ProjectKWBS;

public class KnightedWBSTechnologyForm {

	@NotEmpty
	private List<KnightedWBSTechnology> knightedWBSTechnologies = new ArrayList<KnightedWBSTechnology>();
	
	/*@NotEmpty
	private List<ProjectKWBS> projectKWBSList = new ArrayList<ProjectKWBS>();*/
	
	public KnightedWBSTechnologyForm() {
		// TODO Auto-generated constructor stub
	}
	
	public KnightedWBSTechnologyForm(
			List<KnightedWBSTechnology> knightedWBSTechnologies) {
		super();
		this.knightedWBSTechnologies = knightedWBSTechnologies;
	}

	public List<KnightedWBSTechnology> getKnightedWBSTechnologies() {
		return knightedWBSTechnologies;
	}
	
	//The setter method is named in singular to utilize the convention feature of Spring.
	//Spring tries to look for setXXX (singular) method; Exception is thrown if this name is changed 
	public void setKnightedWBSTechnology(List<KnightedWBSTechnology> knightedWBSTechnologies) {
		this.knightedWBSTechnologies = knightedWBSTechnologies;
	}
/*recent changes - 11/5/2013*/

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the projectKWBSList
	 */
	/*public List<ProjectKWBS> getProjectKWBSList() {
		return projectKWBSList;
	}*/

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param projectKWBSList the projectKWBSList to set
	 */
	/*public void setProjectKWBSList(List<ProjectKWBS> projectKWBSList) {
		this.projectKWBSList = projectKWBSList;
	}*/
	
		
}
