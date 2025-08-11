package com.blackcode.app_chat_be.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_message_chat")
public class MessageChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageChatId;

    private ChatRoom chatRoom;

    private Users sender_id;

    private String context;

    private String messageType;

    private boolean is_read;

    private Timestamp sent_at;

}
