package com.blackcode.app_chat_be.repository;

import com.blackcode.app_chat_be.model.ChatRoomMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomMembersRepository extends JpaRepository<ChatRoomMembers, Long> {
}
