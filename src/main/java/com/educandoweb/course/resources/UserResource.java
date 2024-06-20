package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.OrderService;
import com.educandoweb.course.service.UserService;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService service;

    @Autowired
    OrderService orderService;

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

    @PostMapping("/insert")
    @Transactional
    public ResponseEntity<User> insertUser(@RequestBody User obj, UriComponentsBuilder uriBuilder) {
        User user = service.insert(obj);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);

    }

}
