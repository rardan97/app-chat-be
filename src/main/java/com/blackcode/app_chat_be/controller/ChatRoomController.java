package com.blackcode.app_chat_be.controller;


import com.blackcode.app_chat_be.dto.user.UserRes;
import com.blackcode.app_chat_be.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/chatroom")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @PostMapping("/addInvite")
    public ResponseEntity<List<UserRes>> getListAll(){
        return null;
    }
}
