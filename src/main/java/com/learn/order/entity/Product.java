package com.learn.order.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(
        name = "name",
        nullable = false,
        length = 50
    )
    private String name;
    @Column(
        name = "price",
        nullable = false
    )
    private Double price;
    @ManyToMany
    @JoinTable(
        name = "product_ingredient", 
        joinColumns = @JoinColumn(name = "productId"), 
        inverseJoinColumns = @JoinColumn(name = "ingredientId")
    )
    private List<Ingredient> ingredients;
}
