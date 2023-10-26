package com.aba.setup_spring_security_6.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PatchMapping("changePassword")
    public ResponseEntity<String> changePassword(@RequestBody RequestChangePassword requestChangePassword, Principal connectedUser){
        userService.changePassword(requestChangePassword,connectedUser);
        return ResponseEntity.accepted().build();
    }
}
