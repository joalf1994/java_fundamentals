package com.jbobadilla.exception;

/**
 * Class ClienteNoExisteException
 * <p>
 *
 * @author joalf
 * @version 1.0
 * @Date: 4/07/2026 20:52
 */

public class ClienteNoExisteException extends RuntimeException{
    public ClienteNoExisteException(String message) {
        super(message);
    }
}