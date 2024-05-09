package com.example.SpringPostgRE.service.impl;

import com.example.SpringPostgRE.dto.UserDto;
import com.example.SpringPostgRE.entity.Adress;
import com.example.SpringPostgRE.entity.User;
import com.example.SpringPostgRE.repository.AdressRepo;
import com.example.SpringPostgRE.repository.UserRepo;
import com.example.SpringPostgRE.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final AdressRepo adressRepo;

    @Override
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurName(userDto.getSurName());
        final User userDb = userRepo.save(user);
        List<Adress> list = new ArrayList<>();
        userDto.getAddresses().forEach(item -> {
            Adress adress = new Adress();
            adress.setAdresses(item);
            adress.setAdresTip(Adress.AdresTip.OTHER);
            adress.setActive(true);
            adress.setUser(userDb);
            list.add(adress);
        });
        adressRepo.saveAll(list);
        userDto.setId(userDb.getId());
        log.info("User saved successfully: {}", userDto);
        return userDto;
    }

    @Override
    public void delete(Long id) {
    }


    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(it -> {
            UserDto userDto = new UserDto();
            userDto.setId(it.getId());
            userDto.setName(it.getName());
            userDto.setSurName(it.getSurName());
            userDto.setAddresses(it.getAdresses().stream().map(Adress::getAdresses).collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        log.info("Retrieved all users");
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
