package com.mybang.khweb.controller.gongzi;


import com.mybang.khweb.entity.Gongzi;
import com.mybang.khweb.entity.Product;
import com.mybang.khweb.repository.GongziRepository;
import com.mybang.khweb.repository.ProductRepository;
import com.mybang.khweb.request.GongziRequest;
import com.mybang.khweb.request.ProductRequest;
import com.mybang.khweb.service.GongziService;
import com.mybang.khweb.service.ProductService;
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
@RequestMapping("/gongzi")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j



public class GongziController {
    @Autowired
    private GongziService service;

    @Autowired
    private GongziRepository repository;


    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody GongziRequest request) throws Exception {
        log.info("register():" + request.getTitle() + request.getWriter());

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Gongzi>> list() throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{gongziNo}")
    public ResponseEntity<Gongzi> read(@PathVariable("gongziNo") Long gongziNo) throws Exception {
        Gongzi gongzi = service.read(gongziNo);
        log.info("getLists(): " + service.read(gongziNo));
        return new ResponseEntity<Gongzi>(gongzi, HttpStatus.OK);
    }

    @DeleteMapping("/{gongziNo}")
    public ResponseEntity<Void> remove(@PathVariable("gongziNo") Long gongziNo) throws Exception {
        service.remove(gongziNo);

        log.info("delete complete");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{gongziNo}")
    public ResponseEntity<Void> update(@PathVariable("gongziNo") Long gongziNo,
                                       @RequestBody GongziRequest request) throws Exception {

        Optional<Gongzi> gongzi = repository.findByGongzi(gongziNo);
        Gongzi read = gongzi.get();
        service.modify(read, request);

        log.info("Product Update Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
