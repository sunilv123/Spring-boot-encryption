/**
 * 
 */
package net.sunil.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import net.sunil.dto.LoginDto;
import net.sunil.dto.PublickeyDto;
import net.sunil.security.util.RsaUtil;

/**
 * @author Sunil 25-Apr-2019
 */

@Service
public class RsaServiceImpl {

	@Autowired
	private Gson gson;
	
	public PublickeyDto getPublicKey(HttpServletRequest request) throws Exception {

		PublickeyDto dto = new PublickeyDto(
				RsaUtil.publicKey, getRandomUuid());
		return dto;
	}

	private String getRandomUuid() {

		// creating UUID
		UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");

		// checking the value of random UUID
		return uid.randomUUID() + "";
	}

	/**
	 * @param request
	 * @param dto
	 * @return
	 * @throws IllegalBlockSizeException 
	 * @throws BadPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 */
	public LoginDto saveLoginData(HttpServletRequest request, LoginDto dto) throws Exception {

	    String response =  RsaUtil.decrypt(dto.getPayLoad());
	    
	    
	    LoginDto responseDto =  gson.fromJson(response, LoginDto.class);

	    System.out.println("response : "+responseDto.toString());
		return responseDto;
	}

}
