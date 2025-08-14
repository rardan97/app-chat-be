package com.blackcode.app_chat_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_chat_room")
public class Invite {

    private String fromUser;
    private String toUser;
    private String status; // "PENDING", "ACCEPTED", "REJECTED"
    private LocalDateTime sentAt;


}
