package com.project.osa.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String productName;

    private String price;

    private String manufacturer;

    @Lob
    private byte[] image;

    @ManyToOne
    //@JoinColumn(name="id", nullable=false)
    @JoinColumn(name = "category_id")
    private Category category;
}
