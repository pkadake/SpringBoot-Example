package com.vodafone.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.reward.exception.GenericException;
import com.vodafone.reward.model.Credit;
import com.vodafone.reward.model.Voucher;
import com.vodafone.reward.service.RewardService;
import com.vodafone.reward.to.RequestTo;
import com.vodafone.reward.to.ResponseTo;

/**
 * RewardController
 * 
 * Rest controller for rewards
 * 
 * @author pkadake
 *
 */
@RestController
public class RewardController {

	@Autowired
	RewardService rewardService;

	/**
	 * This method returns a list of rewards which is person-wise aggregate of
	 * the vouchers and credits awarded to them.
	 * 
	 * @param requestTo
	 *            composite object of type InputTo consisting List<> of Voucher
	 *            objects and List<> of Credit objects
	 * @return List of Reward objects
	 * @throws GenericException
	 */
	@RequestMapping(value = "/rewards", method = RequestMethod.POST)
	public ResponseTo getRewardsByPerson(@RequestBody RequestTo requestTo) throws GenericException {
		List<Voucher> vouchers = requestTo.getVouchers();
		List<Credit> credits = requestTo.getCredits();

		return rewardService.getRewardsByPerson(vouchers, credits);
	}

}
