package com.ll.surl20240313.global.stomp;

public interface StompMessageTemplate {
    void convertAndSend(String type, String destination, Object payload);
}
