package com.ll.surl20240313.domain.surl.surl.event;

import com.ll.surl20240313.domain.surl.surl.dto.SurlDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurlCommonEvent {
    private String eventType;
    private SurlDto surlDto;
}
