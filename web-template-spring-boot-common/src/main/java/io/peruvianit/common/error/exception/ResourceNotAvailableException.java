package io.peruvianit.common.error.exception;

import io.peruvianit.common.error.APIException;
import io.peruvianit.common.error.enums.TypeError;

public class ResourceNotAvailableException extends APIException {

	private static final long serialVersionUID = 6330062247047695012L;

	private ResourceNotAvailableException(String message) {
		super(TypeError.RESOURCE_NOT_AVAILABLE_ERROR, message);
	}

	public static ResourceNotAvailableException notAvailable(String codeResource) {
		String message = "Resource not available with code : " + codeResource;
		return new ResourceNotAvailableException(message);
	}

}
