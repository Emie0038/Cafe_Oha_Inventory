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
@Table(name = "menuItem")
public class MenuItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;


    @Column(length = 6000)
    private String instruction;

    @OneToMany
    @JoinColumn(name = "fk_ingredient_id", referencedColumnName = "id")
    private List<IngredientPrice> ingredientPrice;

    public MenuItem(String name,  String instruction) {
        this.name = name;
        this.instruction = instruction;
    }
}
