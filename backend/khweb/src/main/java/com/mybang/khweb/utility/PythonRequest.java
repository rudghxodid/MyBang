package com.mybang.khweb.utility;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;

@Slf4j
public class PythonRequest {
    public String checkEmail(String email, String code) {
        RestTemplate restTemplate = new RestTemplate();

        SendEmail sendCode = new SendEmail(null, email, code);

        return restTemplate.postForObject(
                "http://localhost:5000/checkEmail",
                sendCode,
                String.class
        );
    }

    public String findUserId(String userId, String email) {
        RestTemplate restTemplate = new RestTemplate();

        SendEmail sendUserId = new SendEmail(userId, email, null);

        return restTemplate.postForObject(
                "http://localhost:5000/findIdByEmail",
                sendUserId,
                String.class
        );
    }
    public String findUserPw(String userId, String email) {
        RestTemplate restTemplate = new RestTemplate();

        SendEmail sendUserId = new SendEmail(userId, email, null);

        return restTemplate.postForObject(
                "http://localhost:5000/findPwByEmail",
                sendUserId,
                String.class
        );
    }
}

@Getter
class SendEmail {
    private String userId;
    private String email;
    private String code;

    public SendEmail(String userId, String email, String code) {
        this.userId = userId;
        this.email = email;
        this.code = code;
    }
}
