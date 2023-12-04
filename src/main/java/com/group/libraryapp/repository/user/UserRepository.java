// repository의 역할 -> 데이터베이스나 다른 저장소와의 상호작용을 담당

package com.group.libraryapp.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {
    public boolean isUserNotExist(JdbcTemplate jdbcTemplate, long id){
        String readSql = "SELECT * FROM user WHERE id = ?"; // id를 기준으로 user가 존재하는지 1차 확인
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty(); //SQL을 날려서 DB에 데이터가 있는지 확인
    }

    public void updateUserName(JdbcTemplate jdbcTemplate, String name, long id){
        String sql = "UPDATE user set name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }
}
