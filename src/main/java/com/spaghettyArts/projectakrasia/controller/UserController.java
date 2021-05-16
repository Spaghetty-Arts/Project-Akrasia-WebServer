package com.spaghettyArts.projectakrasia.controller;

import com.spaghettyArts.projectakrasia.model.UserModel;
import com.spaghettyArts.projectakrasia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable Integer id) {
        UserModel obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/login")
    public boolean findById(@RequestParam(value = "user") String user, @RequestParam(value = "pass") String pass) {
        boolean test = service.login(user, pass);
        return test;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserModel> insert(@RequestBody UserModel user) {
        UserModel obj = service.register(user);
        return ResponseEntity.ok().body(obj);
    }
}
