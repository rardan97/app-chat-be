//package com.blackcode.app_chat_be.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.sql.Timestamp;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name = "tb_message_chat")
//public class MessageChat {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long messageChatId;
//
//    @OneToOne
//    @JoinColumn(name = "chatRoom_id", referencedColumnName = "chatRoom_id")
//    private ChatRoom chatRoom;
//
//    @OneToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "userId")
//    private Users sender_id;
//
//    private String context;
//
//    private String messageType;
//
//    private boolean is_read;
//
//    private Timestamp sent_at;
//
//}
