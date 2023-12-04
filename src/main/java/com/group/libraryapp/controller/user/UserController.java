package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final JdbcTemplate jdbcTemplate;
    private final UserService userService = new UserService();

    public UserController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1. POST : 회원(USER) 추가
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){

        String sql = "INSERT INTO user(name, age) VALUES(?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());

        // users.add(new User(request.getName(), request.getAge()));
    }

    // 2. GET : 전체 회원 조회
    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }
    
    // 3. Put : 회원 추가
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(jdbcTemplate, request);
    }
    
    //4. Delete : 회원 삭제
    @DeleteMapping("/user")
    public  void deleteUser(@RequestParam String name) {
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
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
}
