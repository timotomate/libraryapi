package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.userService = new UserService(jdbcTemplate);
    }

    // 1. Create(POST) : 회원(USER) 추가
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    // 2. Read(GET) : 전체 회원 조회
    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    // 3. Update(PUT) : 회원 추가
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    // 4. Delete(DELETE) : 회원 삭제
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
}

//      response를 담을 LIST 만들기 -> LIST에 USER 정보 담기 -> response 출력
//    private final List<User> users = new ArrayList<>();
//    public List<UserResponse> getUsers() {
//        List<UserResponse> responses = new ArrayList<>();
//        for(int i = 0; i< users.size();i++)
//        {
//            responses.add(new UserResponse(i+1, users.get(i)));
//        }
//        return responses;
//    }

