package com.learning.seata.feign.storage.controller;

public class MessageException extends RuntimeException{

    public MessageException() {
    }

    public MessageException(String message) {
        super(message);
    }
}
