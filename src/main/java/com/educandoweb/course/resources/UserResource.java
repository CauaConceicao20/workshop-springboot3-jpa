package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService service;
    @GetMapping("/returnAll")
    public ResponseEntity<List<User>> findAll() {
        var list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/returnId/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

}
