package com.codewithmosh.store.common;

import com.codewithmosh.store.users.Role;
import com.codewithmosh.store.users.User;
import com.codewithmosh.store.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@RequiredArgsConstructor
public class AdminUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setName("admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456")); // 自动加密
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        }
    }
}
