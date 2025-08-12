package com.blackcode.app_chat_be.dto.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserRes {

    private Long userId;

    private String displayName;

    private String email;

    private String username;
}
