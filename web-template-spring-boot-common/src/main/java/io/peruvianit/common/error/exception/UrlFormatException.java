package io.peruvianit.common.error.exception;

import io.peruvianit.common.error.APIException;
import io.peruvianit.common.error.enums.TypeError;

public class UrlFormatException extends APIException {

	private static final long serialVersionUID = -5586794757011298498L;

	UrlFormatException(String message) {
		super(TypeError.URL_FORMAT_ERROR, message);
	}

	public static UrlFormatException create(String url) {
		String message = "The format is not valid : " + url;
		return new UrlFormatException(message);
	}

}
