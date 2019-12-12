package hbc.com.loyalty.UCID.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hbc.com.loyalty.UCID.exceptions.EmailAlreadyExistException;
import hbc.com.loyalty.UCID.exceptions.EmailNotFoundException;
import hbc.com.loyalty.UCID.exceptions.ExtIdValueNotFoundException;
import hbc.com.loyalty.UCID.exceptions.LoyaltyIdNotFoundException;
import hbc.com.loyalty.UCID.exceptions.PhoneAlreadyExistException;
import hbc.com.loyalty.UCID.exceptions.PhoneNotFoundException;
import hbc.com.loyalty.UCID.model.LoyaltyResponse;

//import hbc.com.loyalty.UCID.exceptions.LoyaltyIdNotFoundException;
import hbc.com.loyalty.UCID.model.Loyalty;
import hbc.com.loyalty.UCID.model.LoyaltyLookupReq;

import hbc.com.loyalty.UCID.service.LoyaltyService;

@RestController
public class loyaltyUCIDController {

	@Autowired
	LoyaltyService loyaltyService;
	
	protected Logger logger = Logger.getLogger(loyaltyUCIDController.class.getName());
	
	@RequestMapping(value="/loyaltyLookup", method=RequestMethod.POST, consumes = "application/json")
	public List<Loyalty> getLoyaltyCustomerLoyID(@Valid @RequestBody LoyaltyLookupReq loyaltyLookupReq){
		
		//JsonParser parser = JsonParserFactory.getJsonParser();
	
		long loyId=loyaltyLookupReq.getLoyaltyID();
		System.out.println("LoyID*********" + loyId);
		
		if (loyaltyService.findLoyaltyByLoyaltyID(loyId).isEmpty())
		    throw new LoyaltyIdNotFoundException(loyId);
		
	return loyaltyService.findLoyaltyByLoyaltyID(loyId);
	}	
	
	
	@RequestMapping(value="/phoneLookup", method=RequestMethod.POST, consumes = "application/json")
	public List<Loyalty> getLoyaltyCustomerPhone(@Valid @RequestBody LoyaltyLookupReq loyaltyLookupReq){
		long phone=loyaltyLookupReq.getPhone();
		long bannerId = loyaltyLookupReq.getBannerID();
		System.out.println("phone" + phone);
		
		 if (loyaltyService.findLoyaltyByPhoneAndBannerId(phone, bannerId).isEmpty())
		      throw new PhoneNotFoundException(phone);

		
	//return loyaltyService.findLoyaltyByPhone(phone);
		  return loyaltyService.findLoyaltyByPhoneAndBannerId(phone, bannerId);
			
	}		

	@RequestMapping(value="/enrollCustomer", method=RequestMethod.POST, consumes = "application/json")
	public LoyaltyResponse enrollLoyaltyCustomer(@Valid @RequestBody Loyalty loyalty){
		
     if (!loyaltyService.findLoyaltyByEmail(loyalty.getEmail(), loyalty.getBannerID()).isEmpty()) {
    	 throw new EmailAlreadyExistException(loyalty.getEmail());
     }
     if (!loyaltyService.findLoyaltyByPhoneAndBannerId(loyalty.getPhone(), loyalty.getBannerID()).isEmpty()) {
    	 throw new PhoneAlreadyExistException(loyalty.getPhone());
     }
     else {
    	 return loyaltyService.enrollLoyaltyCustomer(loyalty);
     }
	 
	}	
	
	@RequestMapping(value="/emailLookup", method=RequestMethod.POST, consumes = "application/json")
	public List<Loyalty> getLoyaltyCustomerEmail(@Valid @RequestBody LoyaltyLookupReq loyaltyLookupReq){
		
		 
		
		String email=loyaltyLookupReq.getEmail();
		long bannerId = loyaltyLookupReq.getBannerID();
		System.out.println("email" + email);
		
		if (loyaltyService.findLoyaltyByEmail(email, bannerId).isEmpty())
		      throw new EmailNotFoundException(email);
		
	return loyaltyService.findLoyaltyByEmail(email, bannerId);
	}
	
	@RequestMapping(value="/tokenLookup", method=RequestMethod.POST, consumes = "application/json")
	public Loyalty getLoyaltyCustomerToken(@Valid @RequestBody LoyaltyLookupReq loyaltyLookupReq){
		
		
		
		String extTypeCode=loyaltyLookupReq.getExtIdTypeCode();
		String extTypeValue=loyaltyLookupReq.getExtIdValue();
		//long bannerId = loyaltyLookupReq.getBannerID();
		System.out.println("extTypeCode" + extTypeCode);
		
		if (loyaltyService.findLoyaltyByExtId(extTypeValue, extTypeCode).getLoyaltyExtType().isEmpty())
		      throw new ExtIdValueNotFoundException(extTypeValue);
		
	return loyaltyService.findLoyaltyByExtId(extTypeValue, extTypeCode);
	}

	
}
