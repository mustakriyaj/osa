package com.project.osa.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String userId;

    private String Password;

    private String gender;

    private String streetNo;

    private String  city;

    private String state;

    private String country;

    private String pinCode;
}
