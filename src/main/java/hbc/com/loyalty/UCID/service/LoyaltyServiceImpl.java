package hbc.com.loyalty.UCID.service;


import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import hbc.com.loyalty.UCID.exceptions.ExtIdValueNotFoundException;
import hbc.com.loyalty.UCID.model.LoyaltyExtType;
import hbc.com.loyalty.UCID.model.LoyaltyResponse;

import hbc.com.loyalty.UCID.model.Loyalty;
import hbc.com.loyalty.UCID.model.LoyaltyKey;
import hbc.com.loyalty.UCID.repository.LoyaltyCRUDRepository;
import hbc.com.loyalty.UCID.repository.LoyaltyEnrollCRUDRepository;
import hbc.com.loyalty.UCID.repository.LoyaltyExtCRUDRepository;

import hbc.com.loyalty.UCID.service.LoyaltyService;

@Service("LoyaltyService")
public class LoyaltyServiceImpl implements LoyaltyService{
	
	@Autowired
	LoyaltyCRUDRepository loyaltyCRUDRepository;
	
	@Autowired
	LoyaltyExtCRUDRepository loyaltyExtCRUDRepository;
	
	@Autowired
	LoyaltyEnrollCRUDRepository loyaltyEnrollCRUDRepository;
	
	protected Logger logger = Logger.getLogger(LoyaltyService.class.getName());
	
	@Override
	public List<Loyalty> findLoyaltyByLoyaltyID(Long loyaltyID) {
		
		System.out.println("***** Value *****"+ (2==3));
		
		List<Loyalty> loy = loyaltyCRUDRepository.findByLoyaltyKeyLoyaltyId(loyaltyID);

		return loy;
	}
	
	
	
	@Override
	public List<Loyalty> findLoyaltyByEmail(String email, Long bannerId) {
		// TODO Auto-generated method stub
		return loyaltyCRUDRepository.findByEmailIgnoreCaseAndBannerID(email, bannerId);
	}

	@Override
	public LoyaltyResponse enrollLoyaltyCustomer(Loyalty loyalty) {
		// TODO Auto-generated method stub
		
		LoyaltyKey loyKey = new LoyaltyKey();
		
		loyKey.setIsPrimary('1');
		if (loyaltyEnrollCRUDRepository.max()==null) {
			loyKey.setLoyaltyId((long) 1000000);
		}
		else
		loyKey.setLoyaltyId(loyaltyEnrollCRUDRepository.max()+1);
		loyalty.setLoyaltyKey(loyKey);
		loyaltyCRUDRepository.save(loyalty);
	
		LoyaltyResponse loyResponse = new LoyaltyResponse();
		loyResponse.setLoyaltyID(loyalty.getLoyaltyKey().getLoyaltyId());
	    loyResponse.setRespMessage("Loyalty Member Registered Successfully");
		
		return loyResponse;
	}
	
	
	@Override
	public List<Loyalty> findLoyaltyByPhoneAndBannerId(Long phone, Long bannerId) {
		// TODO Auto-generated method stub
		
		return loyaltyCRUDRepository.findByPhoneAndBannerID(phone, bannerId);
	}
	

	@Override
	public Loyalty findLoyaltyByExtId(String IdTypeValue, String IdTypeCode) {
		// TODO Auto-generated method stub
		
		System.out.println("******Email ID********" + loyaltyExtCRUDRepository.findAll().listIterator().next().getLoyalty().getEmail());
		
		if (loyaltyExtCRUDRepository.findByIdTypeValueAndIdTypeCode(IdTypeValue, IdTypeCode).isEmpty())
		      throw new ExtIdValueNotFoundException(IdTypeValue);
		
		List<LoyaltyExtType> loyExt = loyaltyExtCRUDRepository.findByIdTypeValueAndIdTypeCode(IdTypeValue, IdTypeCode);
		
		Loyalty loy = loyExt.listIterator().next().getLoyalty();
		loy.setLoyaltyExtType(loyExt);
		return loy;
	}

	
	
	

}
