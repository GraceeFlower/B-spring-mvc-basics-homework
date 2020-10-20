package com.thoughtworks.capacity.gtb.mvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    @NotNull(message = "用户名不为空")
    @Pattern(regexp = "\\w{3,10}$", message = "用户名不合法")
    private String username;
    @NotNull(message = "密码是不为空")
    @Pattern(regexp = "^.{5,12}$", message = "密码不合法")
    private String password;
    @Email(message = "邮箱地址不合法")
    private String email;

    public User() {
    }

    public User(String userName, String password, String email) {
        this.username = userName;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
