package com.group.libraryapp.domain;

public class User {

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

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(String.format("Wrong (%s)", name));
        }
        this.name = name;
        this.age = age;
    }
}
