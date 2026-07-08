package com.jbobadilla.exception;

/**
 * Class TransaccionNoExiste
 * <p>
 *
 * @author joalf
 * @version 1.0
 * @Date: 4/07/2026 22:45
 */

public class TransaccionNoExisteException extends RuntimeException{

    public TransaccionNoExisteException(String message) {
        super(message);
    }
}