package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Station;
import com.mybang.khweb.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/station")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class StationController {

    @Autowired
    private StationService service;

    @GetMapping("/lists")
    public ResponseEntity lists() throws Exception {
        log.info("Station Lists");

        List<Station> stations = service.lists();

        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Station>> stationInfo(@PathVariable("name") @RequestBody String name) throws Exception {

        Optional<Station> result = service.findStation(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
