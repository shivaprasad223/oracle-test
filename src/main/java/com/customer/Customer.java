package com.customer;

public class Customer{
	
	private long customerId;
	private long contractId;
	private String geoZone;
	private String teamCode;
	private String projectCode;
	private long buildduration;
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contractId=" + contractId + ", geoZone=" + geoZone
				+ ", teamCode=" + teamCode + ", projectCode=" + projectCode + ", buildduration=" + buildduration + "]";
	}

	public Customer(long customerId,long contractId,String geoZone,String teamCode,String projectCode,long buildduration) {
		this.customerId = customerId;
		this.contractId = contractId;
		this.geoZone = geoZone;
		this.teamCode = teamCode;
		this.projectCode = projectCode;
		this.buildduration = buildduration;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getContractId() {
		return contractId;
	}

	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	public String getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(String geoZone) {
		this.geoZone = geoZone;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public long getBuildduration() {
		return buildduration;
	}

	public void setBuildduration(long buildduration) {
		this.buildduration = buildduration;
	}
	
	
}

