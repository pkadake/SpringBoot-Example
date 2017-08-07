package com.vodafone.reward.service;

import java.util.List;

import com.vodafone.reward.exception.GenericException;
import com.vodafone.reward.model.Credit;
import com.vodafone.reward.model.Reward;
import com.vodafone.reward.model.Voucher;

public interface RewardService {
	public List<Reward> getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) throws GenericException;
}
