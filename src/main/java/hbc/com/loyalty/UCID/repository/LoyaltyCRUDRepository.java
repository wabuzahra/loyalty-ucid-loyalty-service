package hbc.com.loyalty.UCID.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hbc.com.loyalty.UCID.model.Loyalty;
import hbc.com.loyalty.UCID.model.LoyaltyKey;


@Repository
public interface LoyaltyCRUDRepository extends JpaRepository<Loyalty, LoyaltyKey> {

	//Optional<Loyalty> findByLoyaltyID(Long loyaltyID);
      
	//List<Loyalty> findByLoyaltyID(Long loyaltyID);
	
	
	List<Loyalty> findByLoyaltyKeyLoyaltyId(Long loyaltyID);
	
	List<Loyalty> findByPhoneAndBannerID(Long phone, Long bannerId);

	List<Loyalty> findByEmailIgnoreCaseAndBannerID(String email, Long bannerId);

	
	
}
