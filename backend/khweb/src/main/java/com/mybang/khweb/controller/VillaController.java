package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.repository.VillaRepository;
import com.mybang.khweb.request.VillaRequest;
import com.mybang.khweb.service.VillaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/villa")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class VillaController {

    @Autowired
    private VillaService service;

    @Autowired
    private VillaRepository repository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody VillaRequest request) throws Exception {
        log.info("register():");

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity lists() throws Exception {
        log.info("Villa Lists");

        List<Villa> villas = service.lists();

        return new ResponseEntity<>(villas, HttpStatus.OK);
    }

    @GetMapping("/{villaNo}")
    public ResponseEntity<Villa> read(@PathVariable("villaNo") Long villaNo) throws Exception {
        log.info("read");

        Villa villa = service.read(villaNo);

        log.info("Product Read Success");

        return new ResponseEntity<Villa>(villa, HttpStatus.OK);
    }
}
