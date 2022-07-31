package com.assesment.titan.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class PingController {


    @RequestMapping(method = RequestMethod.GET, path = "/api/ping")
    public ResponseEntity<String> getPing() {
        return ResponseEntity.ok("pong");
    }

}
