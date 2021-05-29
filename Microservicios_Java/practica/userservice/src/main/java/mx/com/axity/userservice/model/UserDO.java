package mx.com.axity.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "user")
public class UserDO implements Comparable<UserDO> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "email")
	private String dsEmail;
	
	@Column(name = "password")
	private String dsPassword;
	
	@Column(name = "user_information_id")
	private int userInformationId;
	
	protected UserDO () {
		
	}
	
	public UserDO (int userId, String dsEmail, String dsPassword, int userInformationId) {
		
		this.userId = userId;
		this.dsEmail = dsEmail;
		this.dsPassword = dsPassword;
		this.userInformationId = userInformationId;
	}
	

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.userId).toHashCode();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object object) {

		boolean isEquals = false;

		if (this == object) {
			isEquals = true;
		} else if (object != null && object.getClass().equals(this.getClass())) {
			UserDO that = (UserDO) object;
			isEquals = new EqualsBuilder().append(this.userId, that.userId).isEquals();
		}
		return isEquals;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("userId", this.userId).append("dsEmail", this.dsEmail)
				.append("dsPassword", this.dsPassword).append("userInformationId", this.userInformationId).toString();
	}

	
	@Override
	public int compareTo(UserDO o) {
		return new CompareToBuilder().append(this.userId, o.userId).toComparison();
	}

}
