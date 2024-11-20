package com.proteccion.pruebatecnica.fibonacci.exception;

public class BadRequestException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3462053263798811641L;

	public BadRequestException() {
		super();
	}
	public BadRequestException(String msg) {
        super(msg);
    }
}
