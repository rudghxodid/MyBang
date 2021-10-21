package com.mybang.khweb.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String email;
    private String name;
    private String birth;
    private String sex;
    private String phone;

    private String auth;

    public MemberRequest(String userId, String password, String auth) {
        this.userId = userId;
        this.password = password;
        this.auth = auth;
    }
}