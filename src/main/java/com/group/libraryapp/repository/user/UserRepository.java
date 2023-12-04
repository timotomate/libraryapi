// repository의 역할 -> 데이터베이스나 다른 저장소와의 상호작용을 담당

package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public boolean isUserNotExist(long id){
        String readSql = "SELECT * FROM user WHERE id = ?"; // id를 기준으로 user가 존재하는지 1차 확인
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty(); //SQL을 날려서 DB에 데이터가 있는지 확인
    }
    public boolean isUserNotExist(String name){
        String readSql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    // 1. Create(POST)
    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user(name, age) VALUES(?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    // 2. Read(GET)
    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    // 3. Update(PUT)
    public void updateUserName(String name, long id){
        String sql = "UPDATE user set name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    // 4. Delete(DELETE)
    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}