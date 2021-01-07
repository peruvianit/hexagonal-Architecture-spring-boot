package io.peruvianit.common.error.exception;

import io.peruvianit.common.error.APIException;
import io.peruvianit.common.error.enums.TypeError;

public class MissingParameterException extends APIException {

	private static final long serialVersionUID = -8093762472997016743L;

	MissingParameterException(String messageMissingParam) {
		super(TypeError.MISSING_PARAMETER_ERROR, messageMissingParam);
	}

	public static MissingParameterException create(String paramName) {
		String messageMissingParam = "Missing parameter : " + paramName;
		
		return new MissingParameterException(messageMissingParam);
	}

}
