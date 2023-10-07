package org.springframework.beans;

public class BeansException extends RuntimeException{
    public BeansException(String msg){ super(msg); }

    public BeansException(String name, Throwable cause){ super(name, cause); }
}