package com.vodafone.reward.to;

/** ResponseTo
 * Response envelop class to display list of Reward objects
 * 
 */
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vodafone.reward.model.Reward;

@JsonInclude(Include.NON_NULL)
public class ResponseTo {

	private List<Reward> rewards;

	public ResponseTo() {

	}

	public ResponseTo(List<Reward> rewards) {
		super();
		this.rewards = rewards;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

}
