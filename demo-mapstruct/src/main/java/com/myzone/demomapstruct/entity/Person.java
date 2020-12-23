package com.myzone.demomapstruct.entity;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private Long id;

    private String name;

    private String email;

    private Date birthday;

    private User user;
}
