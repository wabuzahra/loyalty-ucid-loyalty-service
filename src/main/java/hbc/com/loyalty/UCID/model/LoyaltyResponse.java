package hbc.com.loyalty.UCID.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoyaltyResponse {

	private Long loyaltyID;
	private String respMessage;
	
	
	
	public LoyaltyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LoyaltyResponse(Long loyaltyID, String respMessage) {
		super();
		this.loyaltyID = loyaltyID;
		this.respMessage = respMessage;
	}



	public Long getLoyaltyID() {
		return loyaltyID;
	}



	public void setLoyaltyID(Long loyaltyID) {
		this.loyaltyID = loyaltyID;
	}



	public String getRespMessage() {
		return respMessage;
	}



	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	
	
	
	
	
}
