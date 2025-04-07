package com.grepp.servlet.app.member.dto;

import com.grepp.servlet.app.auth.Role;

public class MemberDto {
    private String userId;
    private String password;
    private String email;
    private Role grade;
    private String tell;
    private Boolean isLeave;

    @Override
    public String toString() {
        return "MemberDto{" +
            "userId='" + userId + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", grade=" + grade +
            ", tell='" + tell + '\'' +
            ", isLeave=" + isLeave +
            '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Role getGrade() {
        return grade;
    }

    public void setGrade(Role grade) {
        this.grade = grade;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public Boolean getLeave() {
        return isLeave;
    }

    public void setLeave(Boolean leave) {
        isLeave = leave;
    }
}
