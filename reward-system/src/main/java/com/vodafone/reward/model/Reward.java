package com.vodafone.reward.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "credit", "voucher", "firstname", "lastname" })
public class Reward {

	@JsonProperty("credit")
	private List<String> credit = null;
	@JsonProperty("voucher")
	private List<String> voucher = null;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;

	public Reward() {

	}

	@JsonProperty("credit")
	public List<String> getCredit() {
		return credit;
	}

	@JsonProperty("credit")
	public void setCredit(List<String> credit) {
		this.credit = credit;
	}

	@JsonProperty("voucher")
	public List<String> getVoucher() {
		return voucher;
	}

	@JsonProperty("voucher")
	public void setVoucher(List<String> voucher) {
		this.voucher = voucher;
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

	@Override
	public String toString() {
		return "Reward [credit=" + credit + ", voucher=" + voucher + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}

}
