package io.peruvianit.common.error.exception;

import io.peruvianit.common.error.APIException;
import io.peruvianit.common.error.enums.TypeError;

public class UserNotFoundException extends APIException {

	private static final long serialVersionUID = -1498929893768865478L;

	private UserNotFoundException(String messageMissingParam) {
		super(TypeError.UTENTE_NOT_FOUND_ERROR, messageMissingParam);
	}

	public static UserNotFoundException notFoundByUsername(String paramName) {
		String messageNotFound = "User not found by username : " + paramName;
		
		return new UserNotFoundException(messageNotFound);
	}

}
