package hbc.com.loyalty.UCID.exceptions;

public class PhoneNotFoundException extends RuntimeException {
	
	  public PhoneNotFoundException(Long id) {
	        super("Phone not found : " + id);
	    }


}