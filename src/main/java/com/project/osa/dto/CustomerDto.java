package com.project.osa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class CustomerDto {

    private Integer id;

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
