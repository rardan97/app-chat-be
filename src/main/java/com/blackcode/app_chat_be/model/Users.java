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
@Table(name = "tb_user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String displayName;

    private String email;

    private String username;

    private String password;

    private String status;

    private Timestamp created_at;

    private Timestamp updated_at;

    public Users(String displayName, String email, String username, String password) {
        this.displayName = displayName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
