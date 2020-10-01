package com.kanika.spring.example.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;

   /* @OneToMany
    private List<Product> brandProducts = new ArrayList<Product>();*/
}
