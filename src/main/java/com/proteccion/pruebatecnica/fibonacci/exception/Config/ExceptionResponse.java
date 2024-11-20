package com.proteccion.pruebatecnica.fibonacci.exception.Config;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class ExceptionResponse {

    /**
    *
    * @param key
    * @param argumentos
    * @return
    */
	  public static String getMensaje(String key, Object... argumentos) {
	        String result = "";
	        try {
	            ResourceBundle messages = ResourceBundle.getBundle("idioma_es");
	            result = String.format(messages.getString(key), argumentos);
	        } catch (MissingResourceException ex) {
	        }
	        return result;
	    }
}
