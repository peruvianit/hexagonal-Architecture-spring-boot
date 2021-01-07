package io.peruvianit.common.error.exception;

import io.peruvianit.common.error.APIException;
import io.peruvianit.common.error.enums.TypeError;

public class ResourceAlreadyExistsException extends APIException {

	private static final long serialVersionUID = 7205793453233138107L;

	private ResourceAlreadyExistsException(String message) {
		super(TypeError.RESOURCE_NOT_AVAILABLE_ERROR, message);
	}

	public static ResourceAlreadyExistsException notAvailable(String codeResource) {
		String message = "Resource already exists with code : " + codeResource;
		return new ResourceAlreadyExistsException(message);
	}

}
