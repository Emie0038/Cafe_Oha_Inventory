package com.example.cafebackend.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "mainMenuItem")
public class MainMenuItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "main")
    private String main;


    @Column(length = 6000)
    private String instructions;

    @OneToMany
    @JoinColumn(name = "fk_ingredient_id", referencedColumnName = "id")
    private List<IngredientPrice> ingredientPrice;

    public MainMenuItem(String main,  String instructions) {
        this.main = main;
        this.instructions = instructions;
    }
}
