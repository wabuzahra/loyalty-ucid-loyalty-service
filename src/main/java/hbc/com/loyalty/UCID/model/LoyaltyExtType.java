package hbc.com.loyalty.UCID.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="LOYALTY_EXT_ID_TYPE")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoyaltyExtType {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="ID_TYPE_VALUE")
	private String idTypeValue;
	
	@Column(name="ID_TYPE_CODE")
	private String idTypeCode;
	
	@Column(name="LAST_MOD_DATE")
	private Date lastModDate;
	
	@Column(name="LOY_ID")
	private Long loyID;
	
	@Column(name="LAST_MOD_ID")
	private String lastModId;
	
	@Column(name="PRIMARY_CARD_HOLDER")
	private boolean primaryCardHolder;
	
	@Column(name="AUTHORIZED_SEC_CARD_HOLDER")
	private boolean authorizedSecCardHolder;

	 
	
	//@JsonIgnore
	//@JsonBackReference
	//@ManyToOne(fetch = FetchType.LAZY)
	/*
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="LOY_ID", nullable = false, insertable=false, updatable=false)
	@JoinColumn(name="PRIMARY_CARD_HOLDER", nullable = true, insertable=false, updatable=false)
	private Loyalty loyalty; */
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "LOY_ID", referencedColumnName = "LOYALTY_ID", insertable=false, updatable=false)
    @JoinColumn(name = "PRIMARY_CARD_HOLDER",referencedColumnName = "PRIMARY_HOLDER", insertable=false, updatable=false)
    private Loyalty loyalty;


	public LoyaltyExtType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoyaltyExtType(Long id, String idTypeValue, String idTypeCode, Date lastModDate, Long loyID,
			String lastModId, boolean primaryCardHolder, boolean authorizedSecCardHolder, Loyalty loyalty) {
		super();
		this.id = id;
		this.idTypeValue = idTypeValue;
		this.idTypeCode = idTypeCode;
		this.lastModDate = lastModDate;
		this.loyID = loyID;
		this.lastModId = lastModId;
		this.primaryCardHolder = primaryCardHolder;
		this.authorizedSecCardHolder = authorizedSecCardHolder;
		this.loyalty = loyalty;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIdTypeValue() {
		return idTypeValue;
	}


	public void setIdTypeValue(String idTypeValue) {
		this.idTypeValue = idTypeValue;
	}


	public String getIdTypeCode() {
		return idTypeCode;
	}


	public void setIdTypeCode(String idTypeCode) {
		this.idTypeCode = idTypeCode;
	}


	public Date getLastModDate() {
		return lastModDate;
	}


	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}


	public Long getLoyID() {
		return loyID;
	}


	public void setLoyID(Long loyID) {
		this.loyID = loyID;
	}


	public String getLastModId() {
		return lastModId;
	}


	public void setLastModId(String lastModId) {
		this.lastModId = lastModId;
	}


	public boolean isPrimaryCardHolder() {
		return primaryCardHolder;
	}


	public void setPrimaryCardHolder(boolean primaryCardHolder) {
		this.primaryCardHolder = primaryCardHolder;
	}


	public boolean isAuthorizedSecCardHolder() {
		return authorizedSecCardHolder;
	}


	public void setAuthorizedSecCardHolder(boolean authorizedSecCardHolder) {
		this.authorizedSecCardHolder = authorizedSecCardHolder;
	}


	public Loyalty getLoyalty() {
		return loyalty;
	}


	public void setLoyalty(Loyalty loyalty) {
		this.loyalty = loyalty;
	}

 

	
			

		
	
}
