package hbc.com.loyalty.UCID.exceptions;

public class PhoneAlreadyExistException extends RuntimeException {

	
	 public PhoneAlreadyExistException(Long phone) {
	        super("Phone Already Exist:" + phone);
		 //super();
	    }
}
