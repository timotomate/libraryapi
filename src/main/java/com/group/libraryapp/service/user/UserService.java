package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
        String readSql = "SELECT * FROM user WHERE id = ?"; // id를 기준으로 user가 존재하는지 1차 확인
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty(); //SQL을 날려서 DB에 데이터가 있는지 확인
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE user set name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }
}
