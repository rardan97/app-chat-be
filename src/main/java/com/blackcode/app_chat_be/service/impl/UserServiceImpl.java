package com.blackcode.app_chat_be.service.impl;

import com.blackcode.app_chat_be.dto.user.UserRes;
import com.blackcode.app_chat_be.model.Users;
import com.blackcode.app_chat_be.repository.UserRepository;
import com.blackcode.app_chat_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserRes> getListAll() {
        List<Users> usersList = userRepository.findAll();
        List<UserRes> userResList = new ArrayList<>();
        for (Users rowUser : usersList){
            UserRes userRes = new UserRes();
            userRes.setUserId(rowUser.getUserId());
            userRes.setDisplayName(rowUser.getDisplayName());
            userRes.setEmail(rowUser.getEmail());
            userRes.setUsername(rowUser.getUsername());
            userResList.add(userRes);
        }

        System.out.println("user data size :"+userResList.size());
        return userResList;
    }

    @Override
    public UserRes getFindById(Long userId) {
        Optional<Users> userData = userRepository.findById(userId);
        Users user = userData.get();
        UserRes userRes = new UserRes();
        userRes.setUserId(user.getUserId());
        userRes.setDisplayName(user.getDisplayName());
        userRes.setEmail(user.getEmail());
        userRes.setUsername(user.getUsername());
        return userRes;
    }
}
