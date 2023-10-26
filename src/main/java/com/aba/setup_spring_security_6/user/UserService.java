package com.aba.setup_spring_security_6.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void changePassword(RequestChangePassword requestChangePassword, Principal connectedUser) {
        User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(requestChangePassword.currentPassword(),user.getPassword())) {
            throw new RuntimeException("Password is not correct");
        }

        if (!requestChangePassword.newPassword().equals(requestChangePassword.confirmationPassword())) {
            throw new RuntimeException("confirmation is not correct is not correct");
        }

        user.setPassword(passwordEncoder.encode(requestChangePassword.newPassword()));

        userRepository.save(user);

    }
}
