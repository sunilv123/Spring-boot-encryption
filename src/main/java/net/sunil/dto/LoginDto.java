/**
 * 
 */
package net.sunil.dto;

/**
 * @author Sunil
 * 25-Apr-2019
 */
public class LoginDto {

	private String userName;
	
	private String password;
	
	private String randomUid;
	
	private String payLoad;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRandomUid() {
		return randomUid;
	}
	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRandomUid(String randomUid) {
		this.randomUid = randomUid;
	}

	public String getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}

	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + ", randomUid=" + randomUid + ", payLoad="
				+ payLoad + "]";
	}
	
}
