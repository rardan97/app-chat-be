package com.blackcode.app_chat_be.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRefreshReq {
    @NotBlank
    private String refreshToken;
}
