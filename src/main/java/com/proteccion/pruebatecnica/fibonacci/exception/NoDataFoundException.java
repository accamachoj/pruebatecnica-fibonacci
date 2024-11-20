package com.proteccion.pruebatecnica.fibonacci.exception;

public class NoDataFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1025191825476158187L;

	public NoDataFoundException() {
        super();
    }
	
	public NoDataFoundException(String msg) {
        super(msg);
    }
}
