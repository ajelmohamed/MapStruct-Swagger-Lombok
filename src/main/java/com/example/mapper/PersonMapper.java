package com.example.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.example.dto.PersonDto;
import com.example.entity.Person;
@Mapper()
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
 
	 @Mappings({
		    @Mapping ( source = "person.iduser" , target = "iduser" ),
		    @Mapping ( source = "person.name" , target = "name" ),
		    @Mapping ( source = "person.age" , target = "age" )
		    })
	PersonDto toPersonDto(Person person);
    
    @IterableMapping(elementTargetType = PersonDto.class)
    List<PersonDto> toPersonDtos(List<Person> persons);
    @Mappings({
    @Mapping ( source = "personDto.iduser" , target = "iduser" ),
    @Mapping ( source = "personDto.name" , target = "name" ),
    @Mapping ( source = "personDto.age" , target = "age" )
    })
    Person toPerson(PersonDto personDto);
}
