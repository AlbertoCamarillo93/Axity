package mx.com.axity.userservice.commons.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseTestTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -399992800846350289L;
	
	private int code;
	private String mesage;
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the mesage
	 */
	public String getMesage() {
		return mesage;
	}
	/**
	 * @param mesage the mesage to set
	 */
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("code", this.code).append("message", this.mesage)
				.toString();
	}

}
