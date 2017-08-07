package com.vodafone.reward.to;
/**
 * RequestTo
 * Request envelop class which enclose Lists of types Voucher and Credit
 * 
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vodafone.reward.model.Credit;
import com.vodafone.reward.model.Voucher;

@JsonInclude(Include.NON_NULL)
public class RequestTo {

	private List<Voucher> vouchers;
	private List<Credit> credits;

	public RequestTo() {

	}

	public RequestTo(List<Voucher> vouchers, List<Credit> credits) {
		super();
		this.vouchers = vouchers;
		this.credits = credits;
	}

	public List<Voucher> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

}
