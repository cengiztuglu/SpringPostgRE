package com.example.SpringPostgRE.controller;

import com.example.SpringPostgRE.dto.UserDto;
import com.example.SpringPostgRE.repository.UserRepo;
import com.example.SpringPostgRE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        log.debug("postMapping Starter");
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("list")
    @Cacheable("ListAll")
    public ResponseEntity<List<UserDto>> listAll() {
        log.debug("getMapping Starter");
        return ResponseEntity.ok(userService.getAll());
    }
}
