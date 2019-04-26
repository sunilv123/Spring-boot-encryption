package net.sunil.dto;

import lombok.Data;

@Data
public class GenericResponse {

	private Boolean status;
	
	private String errorMessage;
	
	private Object payLoad;
	
	public GenericResponse(Boolean status, String errorMessage, Object payLoad) {
	
		this.status = status;
		this.errorMessage = errorMessage;
		this.payLoad = payLoad;
	}
	
	public GenericResponse(Boolean status, String errorMessage) {
		
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public GenericResponse(Boolean status, Object payLoad) {
		
		this.status = status;
		this.payLoad = payLoad;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}

	
	
}
