package com.accode.restjava.controller;

import com.accode.restjava.model.LiveStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    @GetMapping
    public List<LiveStream> findAll(){
        return null;
    }

}
