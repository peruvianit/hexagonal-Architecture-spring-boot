package io.peruvianit.web.advice;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.peruvianit.common.error.APIError;
import io.peruvianit.common.error.APIException;
import io.peruvianit.common.error.APIInternaleException;
import io.peruvianit.common.error.HttpErrorResponse;
import io.peruvianit.common.error.enums.TypeError;
import io.peruvianit.common.error.exception.MissingParameterException;
import io.peruvianit.common.error.exception.ResourceAlreadyExistsException;
import io.peruvianit.common.error.exception.ResourceNotAvailableException;
import io.peruvianit.common.error.exception.UrlFormatException;
import io.peruvianit.common.error.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvise {

	private static Logger logger =LoggerFactory.getLogger(ExceptionHandlerControllerAdvise.class);

	@ExceptionHandler(value = { MissingParameterException.class, UrlFormatException.class })

	public ResponseEntity<HttpErrorResponse> handleValidationExceptions(APIException ex,
			HttpServletResponse response) {
		return handleError(ex, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { UserNotFoundException.class })

	public ResponseEntity<HttpErrorResponse> handleMissingResourceExceptions(APIException ex,
			HttpServletResponse response) {
		return handleError(ex, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { ResourceAlreadyExistsException.class })
	public ResponseEntity<HttpErrorResponse> handleAlreadyExistsExceptions(APIException ex,
			HttpServletResponse response) {
		return handleError(ex, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { ResourceNotAvailableException.class })
	public ResponseEntity<HttpErrorResponse> handleActionNotAllowedExceptions(APIException ex,
			HttpServletResponse response) {
		return handleError(ex, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<HttpErrorResponse> handleNotMappedExceptions(Throwable cause) {
		if (cause instanceof APIError) {
			logger.warn("CAUTION!!! Application exception not handled by the server in the class "
					+ ExceptionHandlerControllerAdvise.class.getSimpleName()
					+ "!\n The exception will be remapped to one " + APIInternaleException.class.getSimpleName()
					+ "!");
		}
		APIInternaleException ex = new APIInternaleException(cause);
		return handleInternalServerErrorException(ex);
	}

	@ExceptionHandler(value = { APIInternaleException.class })
	public ResponseEntity<HttpErrorResponse> handleInternalServerErrorException(APIInternaleException ex) {
		logger.error(ex.getMessage(), ex);
		return handleError(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Creazione della risposta di errore 
	 * 
	 * @param apiError
	 * @param httpStatus
	 * @return
	 */
	private ResponseEntity<HttpErrorResponse> handleError(APIError apiError, 
			HttpStatus httpStatus) {
		Throwable tw = (Throwable) apiError;
		String messageError = tw.getMessage();
		Throwable cause = tw.getCause();
		
		TypeError typeError = apiError.getTypeError();
		String detailsError = apiError.getDetailsError();
		
		HttpErrorResponse httpErrorResponse = HttpErrorResponse.crea(
				typeError, 
				messageError, 
				cause != null && detailsError == null ? ExceptionUtils.getStackTrace(cause) : detailsError);
		
		return new ResponseEntity<HttpErrorResponse>(httpErrorResponse, httpStatus);
	}

}