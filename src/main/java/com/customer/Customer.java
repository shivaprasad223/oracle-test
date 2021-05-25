package com.customer;


/**
 * The Class Customer.
 *
 * @author shiva prasad
 */
public class Customer{
	
	/** The customer id. */
	private long customerId;
	
	/** The contract id. */
	private long contractId;
	
	/** The geo zone. */
	private String geoZone;
	
	/** The team code. */
	private String teamCode;
	
	/** The project code. */
	private String projectCode;
	
	/** The buildduration. */
	private long buildduration;
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contractId=" + contractId + ", geoZone=" + geoZone
				+ ", teamCode=" + teamCode + ", projectCode=" + projectCode + ", buildduration=" + buildduration + "]";
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerId the customer id
	 * @param contractId the contract id
	 * @param geoZone the geo zone
	 * @param teamCode the team code
	 * @param projectCode the project code
	 * @param buildduration the buildduration
	 */
	public Customer(long customerId,long contractId,String geoZone,String teamCode,String projectCode,long buildduration) {
		this.customerId = customerId;
		this.contractId = contractId;
		this.geoZone = geoZone;
		this.teamCode = teamCode;
		this.projectCode = projectCode;
		this.buildduration = buildduration;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the contract id.
	 *
	 * @return the contract id
	 */
	public long getContractId() {
		return contractId;
	}

	/**
	 * Sets the contract id.
	 *
	 * @param contractId the new contract id
	 */
	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	/**
	 * Gets the geo zone.
	 *
	 * @return the geo zone
	 */
	public String getGeoZone() {
		return geoZone;
	}

	/**
	 * Sets the geo zone.
	 *
	 * @param geoZone the new geo zone
	 */
	public void setGeoZone(String geoZone) {
		this.geoZone = geoZone;
	}

	/**
	 * Gets the team code.
	 *
	 * @return the team code
	 */
	public String getTeamCode() {
		return teamCode;
	}

	/**
	 * Sets the team code.
	 *
	 * @param teamCode the new team code
	 */
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	/**
	 * Gets the project code.
	 *
	 * @return the project code
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * Sets the project code.
	 *
	 * @param projectCode the new project code
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * Gets the buildduration.
	 *
	 * @return the buildduration
	 */
	public long getBuildduration() {
		return buildduration;
	}

	/**
	 * Sets the buildduration.
	 *
	 * @param buildduration the new buildduration
	 */
	public void setBuildduration(long buildduration) {
		this.buildduration = buildduration;
	}
	
	
}

