package com.language_practice_server.server_demo.mapper;

import com.language_practice_server.server_demo.domain.model.Person;
import com.language_practice_server.server_demo.web.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper
public interface PersonWebMapper {
    Person toModel(PersonDto  personDto);
    PersonDto toDto(Person person);
}
