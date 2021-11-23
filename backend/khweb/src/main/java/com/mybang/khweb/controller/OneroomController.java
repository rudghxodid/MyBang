package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Oneroom;
import com.mybang.khweb.repository.OneroomRepository;
import com.mybang.khweb.request.OneroomRequest;
import com.mybang.khweb.service.OneroomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/oneroom")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class OneroomController {

    @Autowired
    private OneroomService service;

    @Autowired
    private OneroomRepository repository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody OneroomRequest request) throws Exception {
        log.info("register():");

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity lists() throws Exception {
        log.info("Oneroom Lists");

        List<Oneroom> onerooms = service.lists();

        return new ResponseEntity<>(onerooms, HttpStatus.OK);
    }

    @GetMapping("/{oneroomNo}")
    public ResponseEntity <Optional<Oneroom>> read(@PathVariable("oneroomNo") Long oneroomNo) throws Exception {
        log.info("read");

        Optional<Oneroom> oneroom = service.read(oneroomNo);

        log.info("Product Read Success");

        return new ResponseEntity<>(oneroom, HttpStatus.OK);
    }

    @DeleteMapping("/{oneroomNo}")
    public ResponseEntity<Void> remove(@PathVariable("oneroomNo") Long oneroomNo) throws Exception {

        service.remove(oneroomNo);

        log.info("Delete Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{oneroomNo}")
    public ResponseEntity<Void> update(@PathVariable("oneroomNo") Long oneroomNo,
                                       @RequestBody OneroomRequest request) throws Exception {

        Optional<Oneroom> oneroom = repository.findByOneroomNo(oneroomNo);
        Oneroom update = oneroom.get();
        service.modify(update, request);

        log.info("Update Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list/{agentId}")
    public ResponseEntity<List<Oneroom>> agentList(@PathVariable("agentId") String agentId) throws Exception {

        List<Oneroom> oneroomList = service.agentList(agentId);

        return new ResponseEntity<>(oneroomList, HttpStatus.OK);
    }
}
