package com.blackcode.app_chat_be.service;

import com.blackcode.app_chat_be.dto.user.UserRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserRes> getListAll();

    UserRes getFindById(Long userId);




}
