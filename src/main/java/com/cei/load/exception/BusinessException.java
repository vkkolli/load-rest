package com.cei.load.exception;

/**
 * The Class BusinessException.
 */
public class BusinessException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -135657527852153624L;

	/** The status. */
	private int status;

	/** The application code. */
	private int applicationCode;

	/** The developer message. */
	private String developerMessage;

	/**
	 * Instantiates a new business exception.
	 */
	public BusinessException() {
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param cause the cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param status the status
	 * @param developerMessage the developer message
	 * @param exceptionMessage the exception message
	 */
	public BusinessException(int status, String developerMessage, String exceptionMessage) {
		super(exceptionMessage);
		this.status = status;
		this.applicationCode = 3;
		this.developerMessage = developerMessage;
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param status the status
	 * @param applicationCode the application code
	 * @param developerMessage the developer message
	 * @param exceptionMessage the exception message
	 */
	public BusinessException(int status, int applicationCode, String developerMessage, String exceptionMessage) {
		super(exceptionMessage);
		this.status = status;
		this.applicationCode = applicationCode;
		this.developerMessage = developerMessage;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the application code.
	 *
	 * @return the application code
	 */
	public int getApplicationCode() {
		return this.applicationCode;
	}

	/**
	 * Sets the application code.
	 *
	 * @param applicationCode the new application code
	 */
	public void setApplicationCode(int applicationCode) {
		this.applicationCode = applicationCode;
	}

	/**
	 * Gets the developer message.
	 *
	 * @return the developer message
	 */
	public String getDeveloperMessage() {
		return this.developerMessage;
	}

	/**
	 * Sets the developer message.
	 *
	 * @param developerMessage the new developer message
	 */
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
}
