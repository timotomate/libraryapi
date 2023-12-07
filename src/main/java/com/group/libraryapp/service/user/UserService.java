// Service의 역할 -> 비즈니스 로직. 실제 연산이라고 보면 됨(메서드).

package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {

    // private final UserRepository userRepository = new UserRepository();
    private final UserRepository userRepository;
    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    // 1. Create(POST)
    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge());
    }

    // 2. Read(GET)
    public List<UserResponse> getUsers() {
        return userRepository.getUsers();
    }

    // 3. Update(PUT)
    public void updateUser(UserUpdateRequest request) {
        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(request.getName(), request.getId());
    }

    // 4. Delete(DELETE)
    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }
}
