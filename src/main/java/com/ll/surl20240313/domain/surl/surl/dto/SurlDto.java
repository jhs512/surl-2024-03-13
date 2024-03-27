package com.ll.surl20240313.domain.surl.surl.dto;

import com.ll.surl20240313.domain.surl.surl.entity.Surl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurlDto {
    @NonNull
    private long id;
    @NonNull
    private LocalDateTime createDate;
    @NonNull
    private LocalDateTime modifyDate;
    @NonNull
    private long authorId;
    @NonNull
    private String url;
    @NonNull
    private String title;
    @NonNull
    private String body;

    public SurlDto(Surl surl) {
        this.id = surl.getId();
        this.createDate = surl.getCreateDate();
        this.modifyDate = surl.getModifyDate();
        this.authorId = surl.getAuthor().getId();
        this.url = surl.getUrl();
        this.title = surl.getTitle();
        this.body = surl.getBody();
    }
}