package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.repository.VillaRepository;
import com.mybang.khweb.request.ProductRequest;
import com.mybang.khweb.request.VillaRequest;
import com.mybang.khweb.service.VillaService;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity <Optional<Villa>> read(@PathVariable("villaNo") Long villaNo) throws Exception {
        log.info("read");

        Optional<Villa> villa = service.read(villaNo);

        log.info("Product Read Success");

        return new ResponseEntity<>(villa, HttpStatus.OK);
    }

    @DeleteMapping("/{villaNo}")
    public ResponseEntity<Void> remove(@PathVariable("villaNo") Long villaNo) throws Exception {

        service.remove(villaNo);

        log.info("Delete Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{villaNo}")
    public ResponseEntity<Void> update(@PathVariable("villaNo") Long villaNo,
                                       @RequestBody VillaRequest request) throws Exception {

        Optional<Villa> villa = repository.findByVillaNo(villaNo);
        Villa update = villa.get();
        service.modify(update, request);

        log.info("Update Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list/{agentId}")
    public ResponseEntity<List<Villa>> agentList(@PathVariable("agentId") String agentId) throws Exception {
        log.info("사업자 매물 확인");
        List<Villa> villaLists = service.agentList(agentId);

        return new ResponseEntity<>(villaLists, HttpStatus.OK);
    }
}
