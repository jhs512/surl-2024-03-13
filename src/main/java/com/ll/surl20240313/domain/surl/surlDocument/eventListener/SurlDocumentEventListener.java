package com.ll.surl20240313.domain.surl.surlDocument.eventListener;

import com.ll.surl20240313.domain.surl.surl.dto.SurlDto;
import com.ll.surl20240313.domain.surl.surlDocument.service.SurlDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurlDocumentEventListener {
    private final SurlDocumentService surlDocumentService;

    @KafkaListener(topics = "AfterSurlCreatedEvent", groupId = "1")
    public void consumeAfterSurlCreatedEvent(SurlDto surlDto) {
        surlDocumentService.add(surlDto);
    }

    @KafkaListener(topics = "AfterSurlCreatedEvent.DLT", groupId = "1")
    public void consumeAfterSurlCreatedEventDLT(byte[] in) {
        String message = new String(in);
        System.out.println("failed message: " + message);
    }

    @KafkaListener(topics = "AfterSurlModifiedEvent", groupId = "1")
    public void consumeAfterSurlModifiedEvent(SurlDto surlDto) {
        surlDocumentService.modify(surlDto);
    }

    @KafkaListener(topics = "AfterSurlModifiedEvent.DLT", groupId = "1")
    public void consumeAfterSurlModifiedEventDLT(byte[] in) {
        String message = new String(in);
        System.out.println("failed message: " + message);
    }
}