package models;

import java.io.Serializable;

public class Rezervacija implements Serializable {

	private String price;
	private String startingdate;
	private String endingdate;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStartingdate() {
		return startingdate;
	}
	public void SetStartingdate(String startingdate) {
		this.startingdate = startingdate;
	}
	
	public String getEndingdate() {
		return endingdate;
	}
	public void setEndingdate(String endingdate) {
		this.endingdate = endingdate;
	}
	
	
}
