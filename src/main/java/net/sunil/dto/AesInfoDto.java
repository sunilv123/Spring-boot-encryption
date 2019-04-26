/**
 * 
 */
package net.sunil.dto;

import lombok.Data;

/**
 * @author Sunil
 * 25-Apr-2019
 */
@Data
public class AesInfoDto {

	private String key; 
	
	private String IV;

	@Override
	public String toString() {
		return "AesInfoDto [key=" + key + ", IV=" + IV + "]";
	} 
	
	
}
