package com.blackcode.app_chat_be.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_group_chat_detail")
public class GroupChatDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ChatRoom chatRoomId;
    private String name;
    private String description;
}
