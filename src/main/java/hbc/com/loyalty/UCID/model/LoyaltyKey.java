package hbc.com.loyalty.UCID.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoyaltyKey implements Serializable {
	
	
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "LOYALTY_ID")
	Long loyaltyId;
	
	
	@Column(name = "PRIMARY_HOLDER")
	char isPrimary;

	public LoyaltyKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoyaltyKey(Long loyaltyId, char isPrimary) {
		super();
		this.loyaltyId = loyaltyId;
		this.isPrimary = isPrimary;
	}

	public Long getLoyaltyId() {
		return loyaltyId;
	}

	public void setLoyaltyId(Long loyaltyId) {
		this.loyaltyId = loyaltyId;
	}

	public char getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(char isPrimary) {
		this.isPrimary = isPrimary;
	}

	
	
	
	

}
