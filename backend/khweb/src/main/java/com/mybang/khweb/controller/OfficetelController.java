package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Officetel;
import com.mybang.khweb.repository.OfficetelRepository;
import com.mybang.khweb.request.OfficetelRequest;
import com.mybang.khweb.service.OfficetelService;
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
@RequestMapping("/officetel")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class OfficetelController {

    @Autowired
    private OfficetelService service;

    @Autowired
    private OfficetelRepository repository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody OfficetelRequest request) throws Exception {
        log.info("register():");

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity lists() throws Exception {
        log.info("Officetel Lists");

        List<Officetel> officetels = service.lists();

        return new ResponseEntity<>(officetels, HttpStatus.OK);
    }

    @GetMapping("/{officetelNo}")
    public ResponseEntity <Optional<Officetel>> read(@PathVariable("officetelNo") Long officetelNo) throws Exception {
        log.info("read");

        Optional<Officetel> officetel = service.read(officetelNo);

        log.info("Product Read Success");

        return new ResponseEntity<>(officetel, HttpStatus.OK);
    }

    @DeleteMapping("/{officetelNo}")
    public ResponseEntity<Void> remove(@PathVariable("officetelNo") Long officetelNo) throws Exception {

        service.remove(officetelNo);

        log.info("Delete Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{officetelNo}")
    public ResponseEntity<Void> update(@PathVariable("officetelNo") Long officetelNo,
                                       @RequestBody OfficetelRequest request) throws Exception {

        Optional<Officetel> officetel = repository.findByOfficetelNo(officetelNo);
        Officetel update = officetel.get();
        service.modify(update, request);

        log.info("Update Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list/{agentId}")
    public ResponseEntity<List<Officetel>> agentList(@PathVariable("agentId") String agentId) throws Exception {

        List<Officetel> officetelList = service.agentList(agentId);

        return new ResponseEntity<>(officetelList, HttpStatus.OK);
    }
}
