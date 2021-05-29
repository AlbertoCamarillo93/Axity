package mx.com.axity.userservice.commons.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5883983818218341547L;

	private int userId;
	private String dsEmail;
	private String dsPassword;
	private int userInformationId;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the dsEmail
	 */
	public String getDsEmail() {
		return dsEmail;
	}

	/**
	 * @param dsEmail the dsEmail to set
	 */
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	/**
	 * @return the dsPassword
	 */
	public String getDsPassword() {
		return dsPassword;
	}

	/**
	 * @param dsPassword the dsPassword to set
	 */
	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}

	/**
	 * @return the userInformationId
	 */
	public int getUserInformationId() {
		return userInformationId;
	}

	/**
	 * @param userInformationId the userInformationId to set
	 */
	public void setUserInformationId(int userInformationId) {
		this.userInformationId = userInformationId;
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("userId", this.userId).append("dsEmail", this.dsEmail)
				.append("dsPassword", this.dsPassword).append("userInformationId", this.userInformationId).toString();
	}

}
