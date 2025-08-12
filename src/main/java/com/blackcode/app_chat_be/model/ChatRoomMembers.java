package com.blackcode.app_chat_be.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_chat_room_members")
public class ChatRoomMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomMembersId;

    @OneToOne
    @JoinColumn(name = "chatRoom_id", referencedColumnName = "chatRoomId")
    private ChatRoom chatRoom;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Users users;

    private Timestamp joined_at;

}
