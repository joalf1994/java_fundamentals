package com.jbobadilla.exception;

/**
 * Class SaldoInsuficienteException
 * <p>
 * Description: Describe la clase SaldoInsuficienteException
 * @author joalf
 * @version 1.0
 * @Date: 3/07/2026 23:21
 */

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}