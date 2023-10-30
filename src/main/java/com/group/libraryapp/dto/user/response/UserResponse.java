package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.User;

public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserResponse(long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
