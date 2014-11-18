package main.java.com.plm.model;

import java.util.List;

public class KnightedRateWrapper {
	List<KnightedWBSRate> knightedWbsRate;

	public KnightedRateWrapper() {
		// TODO Auto-generated constructor stub
	}

	
	public KnightedRateWrapper(List<KnightedWBSRate> knightedWbsRate) {
		super();
		this.knightedWbsRate = knightedWbsRate;
	}


	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @return the knightedWbsRate
	 */
	public List<KnightedWBSRate> getKnightedWbsRate() {
		return knightedWbsRate;
	}

	/** PLM 2013
		@Author Sanket Bharaswadkar
	 * @param knightedWbsRate the knightedWbsRate to set
	 */
	public void setKnightedWbsRate(List<KnightedWBSRate> knightedWbsRate) {
		this.knightedWbsRate = knightedWbsRate;
	}
	
	
	
}
