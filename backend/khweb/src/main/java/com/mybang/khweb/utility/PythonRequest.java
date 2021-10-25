package com.mybang.khweb.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class PythonRequest {
    public String checkEmail(String email, String code) {
        RestTemplate restTemplate = new RestTemplate();

        SendCode sendCode = new SendCode(email, code);

        return restTemplate.postForObject(
                "http://localhost:5000/checkEmail",
                sendCode,
                String.class
        );
    }
}

class SendCode {
   private String email;
   private String code;

   public SendCode(String email, String code) {
       this.email = email;
       this.code = code;
   }
   public String getEmail() {
       return this.email;
   }
   public String getCode() {
       return this.code;
   }
}
