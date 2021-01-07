/**
 * 
 */
package io.peruvianit.common.error;

import org.apache.commons.lang3.exception.ExceptionUtils;

import io.peruvianit.common.error.enums.TypeError;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class APIInternaleException extends RuntimeException implements APIError {

	private static final long serialVersionUID = -3495881992462290081L;
	
	private TypeError typeError = TypeError.INTERNAL_SERVER_ERROR;
	
	private String detailsError;
	
	public APIInternaleException(String messageError) {
		super(messageError);
	}

	public APIInternaleException(Throwable causeError) {
		super(causeError.getMessage(), causeError);
	}
	
	public APIInternaleException(String messageError, Throwable causeError) {
		super(messageError, causeError);
		this.detailsError = causeError!=null?ExceptionUtils.getRootCauseMessage(causeError):null;
	}

	public APIInternaleException(String messageError, String detailsError) {
		super(messageError);
		this.detailsError = detailsError;
	}
	
	@Override
	public TypeError getTypeError() {
		return this.typeError;
	}

	@Override
	public String getDetailsError() {
		return this.detailsError;
	}
}
