package com.example.demodegrade.degrade;

/**
 * @author ljq
 */
public class DegradeException extends RuntimeException {
    private static final long serialVersionUID = -2601640553575805124L;

    private int errCode;

    public DegradeException() {

    }

    public DegradeException(Throwable cause) {
        super(cause);
    }

    public DegradeException(String msg) {
        super(msg);
    }

    public DegradeException(int errCode) {
        this.errCode = errCode;
    }

    public DegradeException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }
}
