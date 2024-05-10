package com.example.SpringPostgRE.controller;

import com.example.SpringPostgRE.dto.UserDto;
<<<<<<< HEAD
import com.example.SpringPostgRE.repository.UserRepo;
import com.example.SpringPostgRE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
=======
import com.example.SpringPostgRE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
>>>>>>> origin/master
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
<<<<<<< HEAD
    private final UserRepo userRepo;
=======
>>>>>>> origin/master

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        log.debug("postMapping Starter");
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("list")
<<<<<<< HEAD
    @Cacheable("ListAll")
=======
>>>>>>> origin/master
    public ResponseEntity<List<UserDto>> listAll() {
        log.debug("getMapping Starter");
        return ResponseEntity.ok(userService.getAll());
    }
}
