package com.ll.surl20240313.domain.surl.surl.entity;

import com.ll.surl20240313.domain.member.member.entity.Member;
import com.ll.surl20240313.global.jpa.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
public class Surl extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private Member author;
    private String url;
    private String title;
}
