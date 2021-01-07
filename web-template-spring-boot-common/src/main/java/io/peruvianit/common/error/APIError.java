package io.peruvianit.common.error;

import io.peruvianit.common.error.enums.TypeError;

public interface APIError {

	/**
	 * Ritorna il tipo di Errore
	 * 
	 *  @see TypeError
	 */
	TypeError getTypeError();
	
	/**
	 * Ritorna le cause del problema
	 * 
	 * @return
	 */
	String getDetailsError();
	
}
