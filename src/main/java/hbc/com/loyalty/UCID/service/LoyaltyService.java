package hbc.com.loyalty.UCID.service;

import java.util.List;
import java.util.Optional;

import hbc.com.loyalty.UCID.model.Loyalty;
import hbc.com.loyalty.UCID.model.LoyaltyResponse;

public interface LoyaltyService {

	List<Loyalty> findLoyaltyByLoyaltyID(Long loyaltyID);

	List<Loyalty> findLoyaltyByPhoneAndBannerId(Long phone, Long bannerId);

	List<Loyalty> findLoyaltyByEmail(String email, Long bannerId);

	Loyalty findLoyaltyByExtId(String IdTypeValue, String IdTypeCode);

	//LoyaltyResponse enrollLoyaltyCustomer(LoyaltyEnroll loyaltyEnroll);

	LoyaltyResponse enrollLoyaltyCustomer(Loyalty loyalty);
	
	//public Long max();
	
}
