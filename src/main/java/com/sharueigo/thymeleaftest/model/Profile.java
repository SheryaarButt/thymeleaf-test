package com.sharueigo.thymeleaftest.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    private String title;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private String description;
}
