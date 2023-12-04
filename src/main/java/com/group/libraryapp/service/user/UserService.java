// Service의 역할 -> 비즈니스 로직. 실제 연산이라고 보면 됨(메서드).

package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    // 1. 일단 update 하려는 항목이 있는지 부터 먼저 확인
    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
        if (userRepository.isUserNotExist(jdbcTemplate, request.getId())) {
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(jdbcTemplate, request.getName(), request.getId());
    }
}
