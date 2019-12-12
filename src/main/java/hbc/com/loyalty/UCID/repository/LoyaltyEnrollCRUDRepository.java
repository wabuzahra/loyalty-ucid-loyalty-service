package hbc.com.loyalty.UCID.repository;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hbc.com.loyalty.UCID.model.Loyalty;
import hbc.com.loyalty.UCID.model.LoyaltyKey;



@Repository
public interface LoyaltyEnrollCRUDRepository extends CrudRepository<Loyalty, Long> {
	
	//@Column(name = "LOYALTY_ID")
	//LoyaltyKey loyaltyKey = new LoyaltyKey();
	
	@Query(value = "SELECT max(loyaltyKey.loyaltyId) FROM Loyalty")
	public Long max();

}
