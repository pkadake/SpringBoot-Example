package com.vodafone.reward.service.impl;

/**
 * RewardServiceImpl
 * 
 * Service implementation for Rewards
 * 
 * @author pkadake
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vodafone.reward.exception.GenericException;
import com.vodafone.reward.model.Credit;
import com.vodafone.reward.model.Person;
import com.vodafone.reward.model.Reward;
import com.vodafone.reward.model.Voucher;
import com.vodafone.reward.service.RewardService;

@Service("rewardService")
public class RewardServiceImpl implements RewardService {

	/**
	 * This method returns a list of rewards which is person-wise aggregate of
	 * the vouchers and credits awarded to them.
	 * 
	 * @param vouchers
	 *            List<> of Voucher objects,
	 * @param credits
	 *            List<> of Credit objects
	 * @return List<> of Reward objects
	 * 
	 * @throws GenericException
	 */
	@Override
	public List<Reward> getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) throws GenericException {
		Map<Person, Reward> personWiseRewards = new HashMap<>();
		if ((null == vouchers || vouchers.isEmpty()) && (null == credits || credits.isEmpty())) {
			throw new GenericException("Unprocessable Entity: credits and vouchers are empty or null",
					HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failure");
		}
		processVouchers(personWiseRewards, vouchers);
		processCredits(personWiseRewards, credits);

		return new ArrayList<>(personWiseRewards.values());

	}

	/**
	 * This method processes List of Voucher and populate/update respective
	 * Reward object mapped to a Person
	 * 
	 * @param personWiseRewards
	 *            Map<Person, Reward> contains person-wise mapping of rewards
	 * @param voucherList
	 *            List<Voucher>
	 * @throws GenericException
	 */
	private void processVouchers(Map<Person, Reward> personWiseRewards, List<Voucher> voucherList)
			throws GenericException {
		if (null != voucherList && !voucherList.isEmpty()) {
			for (Voucher voucher : voucherList) {
				if (null == voucher.getFirstname() || voucher.getFirstname().isEmpty()) {
					throw new GenericException("Unprocessable Entity:Voucher, firstname is empty or null",
							HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failure");
				}
				if (null == voucher.getLastname() || voucher.getLastname().isEmpty()) {
					throw new GenericException("Unprocessable Entity:Voucher, lastname is empty or null",
							HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failure");
				}
				Person person = new Person(voucher.getFirstname(), voucher.getLastname());
				if (personWiseRewards.containsKey(person)) {
					Reward reward = personWiseRewards.get(person);
					if (null != reward.getVoucher() && !(reward.getVoucher().isEmpty())) {
						reward.getVoucher().add(voucher.getVoucherNumber());
					} else {
						List<String> vouchers = new ArrayList<>();
						vouchers.add(voucher.getVoucherNumber());
						reward.setVoucher(vouchers);
					}

				} else {
					Reward reward = new Reward();
					List<String> vouchers = new ArrayList<>();
					vouchers.add(voucher.getVoucherNumber());
					reward.setFirstname(voucher.getFirstname());
					reward.setLastname(voucher.getLastname());
					reward.setVoucher(vouchers);

					personWiseRewards.put(person, reward);

				}

			}
		}
	}

	/**
	 * This method processes List of Credit and populate/update respective
	 * Reward object mapped to a Person
	 * 
	 * @param personWiseRewards
	 *            Map<Person, Reward> contains person-wise mapping of rewards
	 * @param creditList
	 *            List<Credit>
	 * @throws GenericException
	 */
	private void processCredits(Map<Person, Reward> personWiseRewards, List<Credit> creditList)
			throws GenericException {
		if (null != creditList && !creditList.isEmpty()) {
			for (Credit credit : creditList) {
				if (null == credit.getFirstname() || credit.getFirstname().isEmpty()) {
					throw new GenericException("Unprocessable Entity:Credit, firstname is empty or null",
							HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failure");
				}
				if (null == credit.getLastname() || credit.getLastname().isEmpty()) {
					throw new GenericException("Unprocessable Entity:Credit, lastname is empty or null",
							HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failure");
				}
				Person person = new Person(credit.getFirstname(), credit.getLastname());
				if (personWiseRewards.containsKey(person)) {
					Reward reward = personWiseRewards.get(person);
					if (null != reward.getCredit() && !(reward.getCredit().isEmpty())) {
						reward.getCredit().add(credit.getCreditId());
					} else {
						List<String> credits = new ArrayList<>();
						credits.add(credit.getCreditId());
						reward.setCredit(credits);
					}

				} else {
					Reward reward = new Reward();
					List<String> credits = new ArrayList<>();
					credits.add(credit.getCreditId());
					reward.setFirstname(credit.getFirstname());
					reward.setLastname(credit.getLastname());
					reward.setCredit(credits);

					personWiseRewards.put(person, reward);

				}

			}
		}
	}

}
