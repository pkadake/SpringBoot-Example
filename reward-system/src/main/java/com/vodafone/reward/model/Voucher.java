package com.vodafone.reward.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "voucher-number", "voucher-value", "currency", "firstname", "lastname" })
public class Voucher {

	@JsonProperty("voucher-number")
	private String voucherNumber;
	@JsonProperty("voucher-value")
	private Integer voucherValue;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;

	public Voucher() {

	}

	@JsonProperty("voucher-number")
	public String getVoucherNumber() {
		return voucherNumber;
	}

	@JsonProperty("voucher-number")
	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	@JsonProperty("voucher-value")
	public Integer getVoucherValue() {
		return voucherValue;
	}

	@JsonProperty("voucher-value")
	public void setVoucherValue(Integer voucherValue) {
		this.voucherValue = voucherValue;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("firstname")
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonProperty("lastname")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
