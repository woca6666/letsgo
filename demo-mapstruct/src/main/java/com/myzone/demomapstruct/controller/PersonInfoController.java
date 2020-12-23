package com.myzone.demomapstruct.controller;

import com.myzone.demomapstruct.dto.PersonDTO;
import com.myzone.demomapstruct.entity.Person;
import com.myzone.demomapstruct.entity.User;
import com.myzone.demomapstruct.utils.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PersonInfoController {

    @Autowired
    private PersonConverter personConverter;

    @RequestMapping(value = "/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping(value = "/test")
    public String test() {

        Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1));

//        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);
        PersonDTO personDTO = personConverter.domain2dto(person);

        return personDTO.toString();
    }
}
