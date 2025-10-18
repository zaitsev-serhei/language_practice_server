package com.language_practice_server.server_demo.web.controller;

import com.language_practice_server.server_demo.mapper.PersonWebMapper;
import com.language_practice_server.server_demo.web.dto.PersonDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonController personController;
    private final PersonWebMapper personWebMapper;

    public PersonController(PersonController personController, PersonWebMapper personWebMapper) {
        this.personController = personController;
        this.personWebMapper = personWebMapper;
    }

    //methods
}
