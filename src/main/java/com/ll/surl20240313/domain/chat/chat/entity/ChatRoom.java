package com.ll.surl20240313.domain.chat.chat.entity;

import com.ll.surl20240313.domain.member.member.entity.Member;
import com.ll.surl20240313.global.jpa.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
public class ChatRoom extends BaseTime {
    @ManyToOne
    private Member owner;
    private String name;
    private boolean published;
}
