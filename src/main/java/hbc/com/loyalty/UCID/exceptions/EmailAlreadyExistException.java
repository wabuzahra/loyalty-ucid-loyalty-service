package hbc.com.loyalty.UCID.exceptions;

public class EmailAlreadyExistException extends RuntimeException  {
	
	 public EmailAlreadyExistException(String email) {
	        super("Email Already Exist:" + email);
		 //super();
	    }

}
