package com.blackcode.app_chat_be.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String displayName;

    private String email;

    private String username;

    private String password;

    private String status;

    public Users(String displayName, String email, String username, String password) {
        this.displayName = displayName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
