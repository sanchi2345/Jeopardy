package com.jeopardy.controller;

import com.jeopardy.Interface.Ijeopardy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Getdetails implements Ijeopardy {


    @Override
    @GetMapping("/categories")
    public void getCategory() {
        System.out.println("getCategory function called");
    }

    @Override
    @PostMapping("/players")
    public void addPlayers() {
        System.out.println("addPlayers function called");
    }

    @Override
    @GetMapping("/players/{roomId}")
    public void getPlayers() {
        System.out.println("getPlayers function called");
    }
}
