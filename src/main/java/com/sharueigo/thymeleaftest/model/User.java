package com.sharueigo.thymeleaftest.model;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    @Size(min=3, max=20)
    private String username;
    private String password;
    private String title;
    private String firstname;
    private String lastname;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String zip;
    private String country;
}
