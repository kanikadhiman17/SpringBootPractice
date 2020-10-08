package com.kanika.spring.example.domain.persistence.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    // Will lead to duplication
    /* @OneToMany
    private List<Product> brandProducts = new ArrayList<Product>();*/
}
