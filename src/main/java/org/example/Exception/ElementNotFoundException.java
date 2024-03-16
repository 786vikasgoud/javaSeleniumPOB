package org.example.Exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String msg){
        super(msg);
    }
}
