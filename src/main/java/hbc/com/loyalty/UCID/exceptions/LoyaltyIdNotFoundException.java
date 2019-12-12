package hbc.com.loyalty.UCID.exceptions;

public class LoyaltyIdNotFoundException extends RuntimeException {
	
	  public LoyaltyIdNotFoundException(Long id) {
	        super("Loyalty ID not found : " + id);
	    }


}
