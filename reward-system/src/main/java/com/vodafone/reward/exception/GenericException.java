package com.vodafone.reward.exception;

/**
 * GenericException
 * 
 * Generic envelope for exceptions across application
 * 
 * @author pkadake
 */

public class GenericException extends Exception {

	private static final long serialVersionUID = 8367736239562119590L;

	private int statusCode;

	private String status;

	public GenericException() {
		super();
	}

	public GenericException(Throwable t) {
		super(t);
	}

	public GenericException(String message) {
		super(message);
	}

	public GenericException(String message, Throwable t) {
		super(message, t);
	}

	public GenericException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public GenericException(String message, int statusCode, String status) {
		super(message);
		this.statusCode = statusCode;
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
