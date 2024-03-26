package com.ll.surl20240313.domain.chat.chat.controller;


import com.ll.surl20240313.domain.chat.chat.dto.ChatMessageDto;
import com.ll.surl20240313.domain.chat.chat.entity.ChatMessage;
import com.ll.surl20240313.domain.chat.chat.entity.ChatRoom;
import com.ll.surl20240313.domain.chat.chat.service.ChatService;
import com.ll.surl20240313.domain.member.member.entity.Member;
import com.ll.surl20240313.domain.member.member.service.MemberService;
import com.ll.surl20240313.global.rq.Rq;
import com.ll.surl20240313.global.security.SecurityUser;
import com.ll.surl20240313.global.stomp.StompMessageTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatController {
    private final ChatService chatService;
    private final StompMessageTemplate template;
    private final MemberService memberService;
    private final Rq rq;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{roomId}")
    public String showRoom(
            @PathVariable long roomId,
            Model model
    ) {
        ChatRoom chatRoom = chatService.findRoomById(roomId).get();
        model.addAttribute("chatRoom", chatRoom);

        return "domain/chat/chat/room";
    }

    @GetMapping("/{roomId}/messages")
    @ResponseBody
    public List<ChatMessageDto> getRoomMessages(
            @PathVariable long roomId
    ) {
        List<ChatMessage> messages = chatService.findMessagesByRoomId(roomId);

        return messages
                .stream()
                .map(ChatMessageDto::new)
                .toList();
    }

    public record CreateMessageReqBody(String body) {
    }

    @MessageMapping("/chat/{roomId}/messages/create")
    @Transactional
    public void createMessage(
            CreateMessageReqBody createMessageReqBody,
            @DestinationVariable long roomId,
            Authentication authentication // 웹 소켓에서는 이런식으로 로그인한 유저정보를 얻을 수 있다.
    ) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        Member member = memberService.getReferenceById(securityUser.getId());
        ChatRoom chatRoom = chatService.findRoomById(roomId).get();

        ChatMessage chatMessage = chatService.writeMessage(chatRoom, member, createMessageReqBody.body());

        ChatMessageDto chatMessageDto = new ChatMessageDto(chatMessage);

        template.convertAndSend("topic", "chat" + roomId + "MessageCreated", chatMessageDto);
    }
}
