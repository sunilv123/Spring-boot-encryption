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

import net.sunil.dto.AesInfoDto;
import net.sunil.dto.EncryptedDto;
import net.sunil.dto.GenericResponse;
import net.sunil.dto.LoginDto;
import net.sunil.dto.PublickeyDto;
import net.sunil.security.util.AesUtil;
import net.sunil.security.util.RsaUtil;

/**
 * @author Sunil 25-Apr-2019
 */

@Service
public class RsaServiceImpl {

	@Autowired
	private Gson gson;
	
	public GenericResponse getPublicKey(HttpServletRequest request) throws Exception {

		PublickeyDto dto = new PublickeyDto(
				RsaUtil.publicKey, getRandomUuid());
		return new GenericResponse(true, dto);
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
	public GenericResponse saveLoginData(HttpServletRequest request, EncryptedDto dto) throws Exception {

	    String response =  AesUtil.decryptAngular(dto.getPayLoad());
	    
	    LoginDto responseDto =  gson.fromJson(response, LoginDto.class);

	    System.out.println("response : "+responseDto.toString());
	    
	    String successMessage = "Form submitted successfully";
	    
	    Object json  = AesUtil.encryptAngular(successMessage);
	    
	    return  new GenericResponse(true, json);
	}

	/**
	 * @param dto
	 * @return
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 */
	public GenericResponse saveAesKey(EncryptedDto dto) throws Exception {
		
		    System.out.println("aes info : "+dto.getPayLoad());
		    String response =  RsaUtil.decrypt(dto.getPayLoad());
		    
		    AesInfoDto responseDto =  gson.fromJson(response, AesInfoDto.class);

		    System.out.println("response : "+responseDto.toString());
			
		
		return new GenericResponse(true, "Aes saved successfully");
	}

}
