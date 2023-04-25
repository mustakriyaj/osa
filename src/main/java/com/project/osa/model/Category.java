package com.project.osa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class Category {

    @Id
    private String id;

    private String categoryName;

//    @JsonIgnore
//    @OneToMany(mappedBy="category")
//    private List<Product> product;
}
