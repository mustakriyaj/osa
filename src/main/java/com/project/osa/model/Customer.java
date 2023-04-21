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
}
