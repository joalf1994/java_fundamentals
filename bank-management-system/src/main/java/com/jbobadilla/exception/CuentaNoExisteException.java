package com.jbobadilla.exception;

/**
 * Class CuentaNoExisteException
 * <p>
 *
 * @author joalf
 * @version 1.0
 * @Date: 3/07/2026 23:26
 */

public class CuentaNoExisteException extends RuntimeException{
    public CuentaNoExisteException(String message) {
        super(message);
    }
}