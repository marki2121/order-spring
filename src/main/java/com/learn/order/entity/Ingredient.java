/* (C) 2023 */
package com.learn.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "energy", nullable = false)
  private Integer energy;

  @Column(name = "protein", nullable = false)
  private Double protein;

  @Column(name = "fat", nullable = false)
  private Double fat;

  @Column(name = "carbs", nullable = false)
  private Double carbs;

  @Column(name = "sodium", nullable = false)
  private Double sodium;

  public Ingredient(
      String name, Integer energy, Double protein, Double fat, Double carbs, Double sodium) {
    this.name = name;
    this.energy = energy;
    this.protein = protein;
    this.fat = fat;
    this.carbs = carbs;
    this.sodium = sodium;
  }
}
