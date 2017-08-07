package com.vodafone.reward.model;

/** Credit
 * Entity json equivalent for type Credit 
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "credit-id", "points", "firstname", "lastname" })
public class Credit extends AbstractBaseCreditVoucher {

	@JsonProperty("credit-id")
	private String creditId;
	@JsonProperty("points")
	private Integer points;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;

	public Credit() {

	}

	@JsonProperty("credit-id")
	public String getCreditId() {
		return creditId;
	}

	@JsonProperty("credit-id")
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	@JsonProperty("points")
	public Integer getPoints() {
		return points;
	}

	@JsonProperty("points")
	public void setPoints(Integer points) {
		this.points = points;
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
