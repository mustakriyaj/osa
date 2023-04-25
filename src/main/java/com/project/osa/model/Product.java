package com.project.osa.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class Product {

    @Id
    private String id;

    private String productName;

    private double price;

    private String manufacturer;

//    @ManyToOne
//    private Category category;
}
