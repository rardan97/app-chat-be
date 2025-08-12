package com.blackcode.app_chat_be.controller;

import com.blackcode.app_chat_be.dto.user.UserRes;
import com.blackcode.app_chat_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getListAll")
    public ResponseEntity<List<UserRes>> getListAll(){
        List<UserRes> userRes = userService.getListAll();
        return ResponseEntity.ok(userRes);
    }

    @GetMapping("/getProfileById/{id}")
    public ResponseEntity<UserRes> getCategoryFindById(@PathVariable("id") Long id){
        UserRes userRes = userService.getFindById(id);
        return ResponseEntity.ok(userRes);
    }
}

