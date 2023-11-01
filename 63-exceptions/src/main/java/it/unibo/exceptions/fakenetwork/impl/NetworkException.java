package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {

    private final String message;
    
    public NetworkException() {
        super();
        this.message = "Network error: no response";
    }

    public NetworkException(String message) {
        super();
        this.message = "Network error while sending message: " + message;
    }

    public String toString () {
        return this.message;
    }
}
