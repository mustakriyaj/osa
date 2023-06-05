package com.project.osa.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;
}
