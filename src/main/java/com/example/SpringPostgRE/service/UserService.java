package com.example.SpringPostgRE.service;

import com.example.SpringPostgRE.dto.UserDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    void delete(Long id);
<<<<<<< HEAD
    List<UserDto> getAll();
=======
   List<UserDto> getAll();
>>>>>>> origin/master
    Page<UserDto> getAll(Pageable pageable);
}
