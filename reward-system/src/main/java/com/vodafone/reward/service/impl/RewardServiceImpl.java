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

import com.vodafone.reward.error.ErrorCode;
import com.vodafone.reward.exception.GenericException;
import com.vodafone.reward.model.AbstractBaseCreditVoucher;
import com.vodafone.reward.model.Credit;
import com.vodafone.reward.model.Person;
import com.vodafone.reward.model.Reward;
import com.vodafone.reward.model.Voucher;
import com.vodafone.reward.service.RewardService;
import com.vodafone.reward.to.ResponseTo;

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
	public ResponseTo getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) throws GenericException {
		Map<Person, Reward> personWiseRewards = new HashMap<>();
		List<AbstractBaseCreditVoucher> creditAndVoucherBaseList = new ArrayList<>();
		if ((null == vouchers || vouchers.isEmpty()) && (null == credits || credits.isEmpty())) {
			throw new GenericException(ErrorCode.EMPTY_CREDIT_VOUCHER, HttpStatus.UNPROCESSABLE_ENTITY.value(),
					ErrorCode.FAIL);
		}
		creditAndVoucherBaseList.addAll(vouchers);
		creditAndVoucherBaseList.addAll(credits);

		processCreditAndVoucher(personWiseRewards, creditAndVoucherBaseList);

		return new ResponseTo(new ArrayList<>(personWiseRewards.values()));

	}

	/**
	 * This method processes List of AbstractBaseCreditVoucher which is an
	 * abstract base/parent class of Voucher & Credit. It populates/updates
	 * respective Reward object mapped to a Person
	 * 
	 * @param Map<Person,
	 *            Reward> personWiseRewards
	 * @param List<?
	 *            extends AbstractBaseCreditVoucher> creditAndVoucherBaseList
	 * @throws GenericException
	 */
	private void processCreditAndVoucher(Map<Person, Reward> personWiseRewards,
			List<? extends AbstractBaseCreditVoucher> creditAndVoucherBaseList) throws GenericException {
		if (null != creditAndVoucherBaseList && !creditAndVoucherBaseList.isEmpty()) {
			for (AbstractBaseCreditVoucher baseCreditVoucher : creditAndVoucherBaseList) {
				Person person = null;
				validatePersonDetails(baseCreditVoucher);
				if (baseCreditVoucher instanceof Voucher) {
					Voucher voucher = (Voucher) baseCreditVoucher;
					person = new Person(voucher.getFirstname(), voucher.getLastname());
					if (personWiseRewards.containsKey(person)) {
						Reward reward = personWiseRewards.get(person);
						reward.getVoucher().add(voucher.getVoucherNumber());
					} else {
						Reward reward = new Reward(person);
						reward.getVoucher().add(voucher.getVoucherNumber());
						personWiseRewards.put(person, reward);
					}
				}
				if (baseCreditVoucher instanceof Credit) {
					Credit credit = (Credit) baseCreditVoucher;
					person = new Person(credit.getFirstname(), credit.getLastname());
					if (personWiseRewards.containsKey(person)) {
						Reward reward = personWiseRewards.get(person);
						reward.getCredit().add(credit.getCreditId());
					} else {
						Reward reward = new Reward(person);
						reward.getCredit().add(credit.getCreditId());
						personWiseRewards.put(person, reward);
					}
				}
			}
		}

	}

	/**
	 * This method validates first name and last name from both Voucher and
	 * Credit objects
	 * 
	 * @param baseCreditVoucher
	 * @throws GenericException
	 */
	private void validatePersonDetails(AbstractBaseCreditVoucher baseCreditVoucher) throws GenericException {
		if (baseCreditVoucher instanceof Voucher) {
			Voucher voucher = (Voucher) baseCreditVoucher;
			if (null == voucher.getVoucherNumber() || voucher.getVoucherNumber().isEmpty()) {
				throw new GenericException(ErrorCode.INVALID_VOUCHER, HttpStatus.UNPROCESSABLE_ENTITY.value(),
						ErrorCode.FAIL);
			}
			if (null == voucher.getFirstname() || voucher.getFirstname().isEmpty()) {
				throw new GenericException(ErrorCode.INVALID_FIRST_NAME + ": For voucher with voucher-number:"
						+ voucher.getVoucherNumber(), HttpStatus.UNPROCESSABLE_ENTITY.value(), ErrorCode.FAIL);
			}
			if (null == voucher.getLastname() || voucher.getLastname().isEmpty()) {
				throw new GenericException(
						ErrorCode.INVALID_LAST_NAME + ": For voucher with voucher-number:" + voucher.getVoucherNumber(),
						HttpStatus.UNPROCESSABLE_ENTITY.value(), ErrorCode.FAIL);
			}
		}
		if (baseCreditVoucher instanceof Credit) {
			Credit credit = (Credit) baseCreditVoucher;
			if (null == credit.getCreditId() || credit.getCreditId().isEmpty()) {
				throw new GenericException(ErrorCode.INVALID_CREDIT, HttpStatus.UNPROCESSABLE_ENTITY.value(),
						ErrorCode.FAIL);
			}
			if (null == credit.getFirstname() || credit.getFirstname().isEmpty()) {
				throw new GenericException(
						ErrorCode.INVALID_FIRST_NAME + ": For credit with credit-id:" + credit.getCreditId(),
						HttpStatus.UNPROCESSABLE_ENTITY.value(), ErrorCode.FAIL);
			}
			if (null == credit.getLastname() || credit.getLastname().isEmpty()) {
				throw new GenericException(
						ErrorCode.INVALID_LAST_NAME + ": For credit with credit-id:" + credit.getCreditId(),
						HttpStatus.UNPROCESSABLE_ENTITY.value(), ErrorCode.FAIL);
			}
		}
	}

}
