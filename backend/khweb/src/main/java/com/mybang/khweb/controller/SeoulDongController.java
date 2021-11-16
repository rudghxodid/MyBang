package com.mybang.khweb.controller;

import com.mybang.khweb.entity.SeoulDong;
import com.mybang.khweb.service.SeoulDongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dong")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class SeoulDongController {

    @Autowired
    private SeoulDongService service;

    @GetMapping("/lists")
    public ResponseEntity lists() throws Exception {
        log.info("Dong Lists");

        List<SeoulDong> dongList = service.lists();

        return new ResponseEntity<>(dongList, HttpStatus.OK);
    }

}
