package hbc.com.loyalty.UCID.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hbc.com.loyalty.UCID.model.LoyaltyExtType;


@Repository
public interface LoyaltyExtCRUDRepository extends JpaRepository<LoyaltyExtType, Long> {

	  List<LoyaltyExtType> findByIdTypeValueAndIdTypeCode(String IdTypeValue, String IdTypeCode);
}
