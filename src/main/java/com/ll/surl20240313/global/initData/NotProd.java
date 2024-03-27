package com.ll.surl20240313.global.initData;

import com.ll.surl20240313.domain.chat.chat.entity.ChatRoom;
import com.ll.surl20240313.domain.chat.chat.service.ChatService;
import com.ll.surl20240313.domain.member.member.entity.Member;
import com.ll.surl20240313.domain.member.member.service.MemberService;
import com.ll.surl20240313.domain.surl.surl.service.SurlService;
import com.ll.surl20240313.domain.surl.surlDocument.service.SurlDocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
@Slf4j
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;
    private final SurlService surlService;
    private final MemberService memberService;
    private final ChatService chatService;
    private final SurlDocumentService surlDocumentService;

    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            if (surlService.count() > 0) return;

            self.work1();
        };
    }

    @Transactional
    public void work1() {
        surlDocumentService.clear();
        
        Member memberSystem = memberService.create("system", "1234", "system");
        memberSystem.setRefreshToken("system");

        Member memberAdmin = memberService.create("admin", "1234", "admin");
        memberAdmin.setRefreshToken("admin");

        Member memberGarage = memberService.create("garage", "1234", "garage");
        memberGarage.setRefreshToken("garage");

        Member memberUser1 = memberService.create("user1", "1234", "user1");
        memberUser1.setRefreshToken("user1");

        Member memberUser2 = memberService.create("user2", "1234", "user2");
        memberUser2.setRefreshToken("user2");

        Member memberUser3 = memberService.create("user3", "1234", "user3");
        memberUser3.setRefreshToken("user3");

        surlService.create(memberUser1, "https://www.naver.com", "네이버");
        surlService.create(memberUser1, "https://www.google.com", "구글");
        surlService.create(memberUser2, "https://www.daum.net", "다음");

        ChatRoom room1 = chatService.createRoom(memberUser1, "room1");
        ChatRoom room2 = chatService.createRoom(memberUser2, "room2");
        ChatRoom room3 = chatService.createRoom(memberUser3, "room3");

        chatService.writeMessage(room1, memberUser1, "message1");
        chatService.writeMessage(room1, memberUser1, "message2");
        chatService.writeMessage(room1, memberUser1, "message3");

        chatService.writeMessage(room1, memberUser2, "message4");
        chatService.writeMessage(room1, memberUser2, "message5");

        chatService.writeMessage(room1, memberUser3, "message6");

        chatService.writeMessage(room2, memberUser1, "message7");
        chatService.writeMessage(room2, memberUser2, "message8");

        chatService.writeMessage(room3, memberUser1, "message9");

        ChatRoom room4 = chatService.createRoom(memberUser1, "room4");
        ChatRoom room5 = chatService.createRoom(memberUser2, "room5");
        ChatRoom room6 = chatService.createRoom(memberUser3, "room6");

        ChatRoom room7 = chatService.createRoom(memberUser1, "room7");
        ChatRoom room8 = chatService.createRoom(memberUser2, "room8");
        ChatRoom room9 = chatService.createRoom(memberUser3, "room9");

        ChatRoom room10 = chatService.createRoom(memberUser1, "room10");
        ChatRoom room11 = chatService.createRoom(memberUser2, "room11");
        ChatRoom room12 = chatService.createRoom(memberUser3, "room12");

        ChatRoom room13 = chatService.createRoom(memberUser1, "room13");
        ChatRoom room14 = chatService.createRoom(memberUser2, "room14");
        ChatRoom room15 = chatService.createRoom(memberUser3, "room15");

        chatService.writeMessage(room13, memberUser1, "message10");
        chatService.writeMessage(room13, memberUser1, "message11");
        chatService.writeMessage(room13, memberUser1, "message12");

        chatService.writeMessage(room13, memberUser2, "message13");
        chatService.writeMessage(room13, memberUser2, "message14");

        chatService.writeMessage(room13, memberUser3, "message15");

        chatService.writeMessage(room14, memberUser1, "message16");
        chatService.writeMessage(room14, memberUser2, "message17");

        chatService.writeMessage(room15, memberUser1, "message18");
    }
}
