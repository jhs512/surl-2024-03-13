package com.ll.surl20240313.domain.surl.surlDocument.document;

import com.ll.surl20240313.domain.surl.surl.dto.SurlDto;
import com.ll.surl20240313.standard.util.Ut.Ut;
import lombok.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SurlDocument {
    @NonNull
    private long id;
    @NonNull
    private LocalDateTime createDate;
    @NonNull
    private long createTimeStamp;
    @NonNull
    private LocalDateTime modifyDate;
    @NonNull
    private long modifyTimeStamp;
    @NonNull
    private long authorId;
    @NonNull
    private String url;
    @NonNull
    private String title;
    @NonNull
    private String body;

    public SurlDocument(SurlDto surlDto) {
        this.id = surlDto.getId();
        this.createDate = surlDto.getCreateDate();
        this.createTimeStamp = Ut.time.toTimeStamp(surlDto.getCreateDate());
        this.modifyDate = surlDto.getModifyDate();
        this.modifyTimeStamp = Ut.time.toTimeStamp(surlDto.getModifyDate());
        this.authorId = surlDto.getAuthorId();
        this.url = surlDto.getUrl();
        this.title = surlDto.getTitle();
        this.body = surlDto.getBody();
    }
}