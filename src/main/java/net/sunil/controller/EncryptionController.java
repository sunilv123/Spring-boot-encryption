/**
 * 
 */
package net.sunil.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.sunil.dto.EncryptedDto;
import net.sunil.dto.GenericResponse;
import net.sunil.service.impl.RsaServiceImpl;

/**
 * @author Sunil
 * 25-Apr-2019
 */

@RestController
@CrossOrigin
public class EncryptionController {

	@Autowired
	private RsaServiceImpl rsaServiceImpl;
	
	 //Give Public API
    @GetMapping(value = "/get-public-key")
    public GenericResponse getPublicKey(HttpServletRequest request) throws Exception {
    	return rsaServiceImpl.getPublicKey(request) ;
    }
    
    @PostMapping(value = "/save-aes-key")
    public GenericResponse saveAesKey(HttpServletRequest request, @RequestBody EncryptedDto dto) throws Exception {
    	return rsaServiceImpl.saveAesKey(dto) ;
    }
    
    
    @PostMapping(value = "/save-data")
    public GenericResponse getPublicKey(HttpServletRequest request, @RequestBody EncryptedDto dto) throws Exception {
    	return rsaServiceImpl.saveLoginData(request, dto) ;
    }
	
}
