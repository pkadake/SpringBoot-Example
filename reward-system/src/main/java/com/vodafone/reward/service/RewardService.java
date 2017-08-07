package com.vodafone.reward.service;

import java.util.List;

import com.vodafone.reward.exception.GenericException;
import com.vodafone.reward.model.Credit;
import com.vodafone.reward.model.Voucher;
import com.vodafone.reward.to.ResponseTo;

public interface RewardService {
	public ResponseTo getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) throws GenericException;
}
