package io.peruvianit.common.error.enums;

/**
 * Classe per le tipologie di errori
 * 
 * 100 a 199 : Errori Applicativi
 * 200 a 299 : Errori Servizi Primary
 * 300 a 399 : Errori Servizi Secondary
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */
public enum TypeError {
	MISSING_PARAMETER_ERROR("101","Missing parameter"),
	URL_FORMAT_ERROR("102","Error format url"),
	
	INVALID_TOKEN_ERROR("201","Token not valid"),
	
	INTERNAL_SERVER_ERROR("500", "Internal application error");

	private String errorCode;
	public String description;

	public String getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}

	private TypeError(String errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}
	
}
