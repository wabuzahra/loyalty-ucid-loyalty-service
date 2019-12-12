package hbc.com.loyalty.UCID.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class LoyaltyLookupReq {
	
	
	
	@NotNull(message = "bannerID is mandatory field.")
	private Long bannerID;
	
	private String firstName;
	
	private String lastName;
	
	private Long loyaltyID;
	
	private String email;
	
	private Long phone;
	
	private String extIdTypeCode;
	
	private String extIdValue;

	public LoyaltyLookupReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoyaltyLookupReq(Long bannerID, String firstName, String lastName, Long loyaltyID, String email, Long phone,
			String extIdTypeCode, String extIdValue) {
		super();
		this.bannerID = bannerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loyaltyID = loyaltyID;
		this.email = email;
		this.phone = phone;
		this.extIdTypeCode = extIdTypeCode;
		this.extIdValue = extIdValue;
	}

	public Long getBannerID() {
		return bannerID;
	}

	public void setBannerID(Long bannerID) {
		this.bannerID = bannerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getLoyaltyID() {
		return loyaltyID;
	}

	public void setLoyaltyID(Long loyaltyID) {
		this.loyaltyID = loyaltyID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getExtIdTypeCode() {
		return extIdTypeCode;
	}

	public void setExtIdTypeCode(String extIdTypeCode) {
		this.extIdTypeCode = extIdTypeCode;
	}

	public String getExtIdValue() {
		return extIdValue;
	}

	public void setExtIdValue(String extIdValue) {
		this.extIdValue = extIdValue;
	}
	
	
	
	

}
