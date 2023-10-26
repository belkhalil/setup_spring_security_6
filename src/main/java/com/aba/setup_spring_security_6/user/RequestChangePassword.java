package com.aba.setup_spring_security_6.user;

public record RequestChangePassword(String currentPassword,
                                    String newPassword,
                                    String confirmationPassword) {
}
