package com.ll.surl20240313.domain.chat.chat.repository;


import com.ll.surl20240313.domain.chat.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, ChatRoomRepositoryCustom {

}
