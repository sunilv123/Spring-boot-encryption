/**
 * 
 */
package net.sunil.dto;

/**
 * @author Sunil
 * 25-Apr-2019
 */
public class PublickeyDto {

	private String publicKey;
	
	private String randomUid;
	
	public PublickeyDto(String publicKey, String randomUid) {
		
		this.publicKey = publicKey;
		
		this.randomUid = randomUid;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public String getRandomUid() {
		return randomUid;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public void setRandomUid(String randomUid) {
		this.randomUid = randomUid;
	}
	
}
