package hbc.com.loyalty.UCID.exceptions;

public class ExtIdValueNotFoundException extends RuntimeException {

	 public ExtIdValueNotFoundException(String token) {
	        super("Token not found : " + token);
	    }


}