package com.ll.surl20240313.domain.chat.chat.repository;

import com.ll.surl20240313.domain.chat.chat.entity.ChatRoom;
import com.ll.surl20240313.domain.member.member.entity.Member;
import com.ll.surl20240313.standard.base.KwTypeV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatRoomRepositoryCustom {
    Page<ChatRoom> findByKw(KwTypeV2 kwType, String kw, Member owner, Boolean published, Pageable pageable);
}
