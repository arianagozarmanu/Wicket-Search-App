package wicket.helloworld;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> codes = new ArrayList<String>();
	
	public List<String> getMyCodes() {
		return codes;
	}
	
	public void setMyCodes(List<String> otherCodes) {
		codes = otherCodes;
	}
	
	public int getTotal() {
		return codes.size();
	}
	
}
