package main.java.com.plm.form;

import java.util.ArrayList;
import java.util.List;

import main.java.com.plm.model.KnightedWBSRate;

public class KnightedWBSRateForm {

	private List<KnightedWBSRate> knightedWBSRates = new ArrayList<KnightedWBSRate>();
	
	public KnightedWBSRateForm() {
		// TODO Auto-generated constructor stub
	}
	
	

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the knightedWBSRates
	 */
	public List<KnightedWBSRate> getKnightedWBSRates() {
		return knightedWBSRates;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param knightedWBSRates the knightedWBSRates to set
	 */
	public void setKnightedWBSRates(List<KnightedWBSRate> knightedWBSRates) {
		this.knightedWBSRates = knightedWBSRates;
	}
	
	

	
}
