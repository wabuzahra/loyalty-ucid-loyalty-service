package hbc.com.loyalty.UCID.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="LOYALTY")
//@SequenceGenerator(name="seq", initialValue=100000, allocationSize=10)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Loyalty {
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="LOYALTY_ID")
	private Long loyaltyID; */
	
	@EmbeddedId
	private LoyaltyKey loyaltyKey;
	
	private Long UCID;
	
	@NotNull(message = "BANNER_ID is mandatory field.")
	@Column(name="BANNER_ID")
	private Long bannerID;
	
	@NotNull(message = "FIRST NAME is Mandatory field.")
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotNull(message = "LAST NAME is Mandatory field.")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@NotNull(message = "EMAIL is Mandatory field.")
	@Column(name="EMAIL")
	private String email;
	
	@NotNull(message = "PHONE is Mandatory field.")
	@Column(name="PHONE")
	private Long phone;
	
	@Column(name="SEC_PHONE")
	private Long secondaryPhone;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	@Column(name="ADDRESS3")
	private String address3;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@NotNull(message = "POSTAL CODE is Mandatory field.")
	@Column(name="POSTAL")
	private String postal;
	
	@Column(name="LANGUAGE_PREF_CD")
	private String languagePrefCode;
	
	@Column(name="LOYALTY_CONSENT_DATE")
	private Date loyaltyConsentDate;
	
	@Column(name="LOYALTY_CONSENT_SOURCE")
	private String loyaltyConsentSource;
	
	@NotNull(message = "CASL_EMAIL is Mandatory field.")
	@Column(name="CASL_EMAIL")
	private boolean caslEmail;
	
	@Column(name="CASL_ADDRESS")
	private boolean caslPhone;
	
	@Column(name="CASL_PHONE")
	private boolean caslAddress;
	
	@Column(name="LOYALTY_EXP_DATE")
	private Date loyaltyExpDate;
	
	@Column(name="POINT_BAL_EXP")
	private Long pointBalanceExpired;
	
	@Column(name="LAST_KNOWN__POINTS")
	private Long lastKnownPoints;
	
	@Column(name="LAST_KNOWN_POINTS_VALUE")
	private Long lastKnownPointsValue;
	
	@Column(name="ASSOCIATE_FLAG")
	private boolean associateFlag;
	
	@Column(name="DISCOUNT_ELIGIBLTY_FLAG")
	private boolean discountEligibilityFlag;
	
	@Column(name="ENROLL_TYPE")
	private String enrollType;
	
	@Column(name="ENROLL_SOURCE")
	private String enrollSource;
	
	@Column(name="ENROLL_TS")
	private Date enrollTS;
	
	@Column(name="ENROLL_LAST_UPDATED_SOURCE")
	private String enrollLastUpdatedSource;
	
	@Column(name="ENROLL_LAST_UPDATE_TS")
	private Date enrolllastUpdateTS;
	
	@Column(name="DOB")
	private Date dateOfBirth;
	
	@Column(name="TIER")
	private String tier;
	
	@Column(name="SUB_CHANNEL")
	private String subChannel;
	
	@NotNull(message = "PHONE TYPE is Mandatory field.")
	@Column(name="PHONE_TYPE")
	private String phoneType;
	
	//@Column(name="PRIMARY_HOLDER")
	//private boolean primary;
	
	
	//@OneToMany(mappedBy="loyalty")
	//private List<LoyaltyExtType> loyaltyExtType = new ArrayList<LoyaltyExtType>();

	/*
	@JsonManagedReference
	@OneToMany(mappedBy = "loyalty", cascade = CascadeType.ALL)
    private Set<LoyaltyExtType> loyaltyExtType;
	*/
	
	 //@JsonManagedReference
	 //@OneToMany(mappedBy = "loyalty", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 //private Set<LoyaltyExtType> loyaltyExtType = new HashSet<>();
    
	
	@JsonManagedReference
	@OneToMany(mappedBy = "loyalty")
    private List<LoyaltyExtType> loyaltyExtType = new ArrayList<LoyaltyExtType>();
	
	

	public Loyalty() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Loyalty(LoyaltyKey loyaltyKey, Long uCID, @NotNull(message = "BANNER_ID is mandatory field.") Long bannerID,
			@NotNull(message = "FIRST NAME is Mandatory field.") String firstName,
			@NotNull(message = "LAST NAME is Mandatory field.") String lastName,
			@NotNull(message = "EMAIL is Mandatory field.") String email,
			@NotNull(message = "PHONE is Mandatory field.") Long phone, Long secondaryPhone, String address1,
			String address2, String address3, String city, String state,
			@NotNull(message = "POSTAL CODE is Mandatory field.") String postal, String languagePrefCode,
			Date loyaltyConsentDate, String loyaltyConsentSource,
			@NotNull(message = "CASL_EMAIL is Mandatory field.") boolean caslEmail, boolean caslPhone,
			boolean caslAddress, Date loyaltyExpDate, Long pointBalanceExpired, Long lastKnownPoints,
			Long lastKnownPointsValue, boolean associateFlag, boolean discountEligibilityFlag, String enrollType,
			String enrollSource, Date enrollTS, String enrollLastUpdatedSource, Date enrolllastUpdateTS,
			Date dateOfBirth, String tier, String subChannel,
			@NotNull(message = "PHONE TYPE is Mandatory field.") String phoneType,
			List<LoyaltyExtType> loyaltyExtType) {
		super();
		this.loyaltyKey = loyaltyKey;
		UCID = uCID;
		this.bannerID = bannerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.secondaryPhone = secondaryPhone;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.postal = postal;
		this.languagePrefCode = languagePrefCode;
		this.loyaltyConsentDate = loyaltyConsentDate;
		this.loyaltyConsentSource = loyaltyConsentSource;
		this.caslEmail = caslEmail;
		this.caslPhone = caslPhone;
		this.caslAddress = caslAddress;
		this.loyaltyExpDate = loyaltyExpDate;
		this.pointBalanceExpired = pointBalanceExpired;
		this.lastKnownPoints = lastKnownPoints;
		this.lastKnownPointsValue = lastKnownPointsValue;
		this.associateFlag = associateFlag;
		this.discountEligibilityFlag = discountEligibilityFlag;
		this.enrollType = enrollType;
		this.enrollSource = enrollSource;
		this.enrollTS = enrollTS;
		this.enrollLastUpdatedSource = enrollLastUpdatedSource;
		this.enrolllastUpdateTS = enrolllastUpdateTS;
		this.dateOfBirth = dateOfBirth;
		this.tier = tier;
		this.subChannel = subChannel;
		this.phoneType = phoneType;
		this.loyaltyExtType = loyaltyExtType;
	}



	public LoyaltyKey getLoyaltyKey() {
		return loyaltyKey;
	}



	public void setLoyaltyKey(LoyaltyKey loyaltyKey) {
		this.loyaltyKey = loyaltyKey;
	}



	public Long getUCID() {
		return UCID;
	}



	public void setUCID(Long uCID) {
		UCID = uCID;
	}



	public Long getBannerID() {
		return bannerID;
	}



	public void setBannerID(Long bannerID) {
		this.bannerID = bannerID;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Long getPhone() {
		return phone;
	}



	public void setPhone(Long phone) {
		this.phone = phone;
	}



	public Long getSecondaryPhone() {
		return secondaryPhone;
	}



	public void setSecondaryPhone(Long secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}



	public String getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	public String getAddress3() {
		return address3;
	}



	public void setAddress3(String address3) {
		this.address3 = address3;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPostal() {
		return postal;
	}



	public void setPostal(String postal) {
		this.postal = postal;
	}



	public String getLanguagePrefCode() {
		return languagePrefCode;
	}



	public void setLanguagePrefCode(String languagePrefCode) {
		this.languagePrefCode = languagePrefCode;
	}



	public Date getLoyaltyConsentDate() {
		return loyaltyConsentDate;
	}



	public void setLoyaltyConsentDate(Date loyaltyConsentDate) {
		this.loyaltyConsentDate = loyaltyConsentDate;
	}



	public String getLoyaltyConsentSource() {
		return loyaltyConsentSource;
	}



	public void setLoyaltyConsentSource(String loyaltyConsentSource) {
		this.loyaltyConsentSource = loyaltyConsentSource;
	}



	public boolean isCaslEmail() {
		return caslEmail;
	}



	public void setCaslEmail(boolean caslEmail) {
		this.caslEmail = caslEmail;
	}



	public boolean isCaslPhone() {
		return caslPhone;
	}



	public void setCaslPhone(boolean caslPhone) {
		this.caslPhone = caslPhone;
	}



	public boolean isCaslAddress() {
		return caslAddress;
	}



	public void setCaslAddress(boolean caslAddress) {
		this.caslAddress = caslAddress;
	}



	public Date getLoyaltyExpDate() {
		return loyaltyExpDate;
	}



	public void setLoyaltyExpDate(Date loyaltyExpDate) {
		this.loyaltyExpDate = loyaltyExpDate;
	}



	public Long getPointBalanceExpired() {
		return pointBalanceExpired;
	}



	public void setPointBalanceExpired(Long pointBalanceExpired) {
		this.pointBalanceExpired = pointBalanceExpired;
	}



	public Long getLastKnownPoints() {
		return lastKnownPoints;
	}



	public void setLastKnownPoints(Long lastKnownPoints) {
		this.lastKnownPoints = lastKnownPoints;
	}



	public Long getLastKnownPointsValue() {
		return lastKnownPointsValue;
	}



	public void setLastKnownPointsValue(Long lastKnownPointsValue) {
		this.lastKnownPointsValue = lastKnownPointsValue;
	}



	public boolean isAssociateFlag() {
		return associateFlag;
	}



	public void setAssociateFlag(boolean associateFlag) {
		this.associateFlag = associateFlag;
	}



	public boolean isDiscountEligibilityFlag() {
		return discountEligibilityFlag;
	}



	public void setDiscountEligibilityFlag(boolean discountEligibilityFlag) {
		this.discountEligibilityFlag = discountEligibilityFlag;
	}



	public String getEnrollType() {
		return enrollType;
	}



	public void setEnrollType(String enrollType) {
		this.enrollType = enrollType;
	}



	public String getEnrollSource() {
		return enrollSource;
	}



	public void setEnrollSource(String enrollSource) {
		this.enrollSource = enrollSource;
	}



	public Date getEnrollTS() {
		return enrollTS;
	}



	public void setEnrollTS(Date enrollTS) {
		this.enrollTS = enrollTS;
	}



	public String getEnrollLastUpdatedSource() {
		return enrollLastUpdatedSource;
	}



	public void setEnrollLastUpdatedSource(String enrollLastUpdatedSource) {
		this.enrollLastUpdatedSource = enrollLastUpdatedSource;
	}



	public Date getEnrolllastUpdateTS() {
		return enrolllastUpdateTS;
	}



	public void setEnrolllastUpdateTS(Date enrolllastUpdateTS) {
		this.enrolllastUpdateTS = enrolllastUpdateTS;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getTier() {
		return tier;
	}



	public void setTier(String tier) {
		this.tier = tier;
	}



	public String getSubChannel() {
		return subChannel;
	}



	public void setSubChannel(String subChannel) {
		this.subChannel = subChannel;
	}



	public String getPhoneType() {
		return phoneType;
	}



	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}



	public List<LoyaltyExtType> getLoyaltyExtType() {
		return loyaltyExtType;
	}



	public void setLoyaltyExtType(List<LoyaltyExtType> loyaltyExtType) {
		this.loyaltyExtType = loyaltyExtType;
	}






}
