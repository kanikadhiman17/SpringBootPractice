package com.kanika.spring.example.entity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data // Lombok
@AllArgsConstructor // Lombok - All arguments constructor
@NoArgsConstructor // Lombok - No Argument Constructor
@Entity // JPA
@Table // A table with same name as of class
public class Product {
    @Id // This is primary key
    @GeneratedValue // By Hibernate, as we don't want to give id on our own
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;

    @Min(1)
    @Max(10)
    private int quantity;

    @Size(min = 10, max=100000)
    private double price;

    @ManyToOne
    @JoinColumn(name="fk_brand", nullable = false) // Column name will now be brand_id
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;

}
