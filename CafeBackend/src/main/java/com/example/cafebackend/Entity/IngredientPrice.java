package com.example.cafebackend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity(name = "IngredientPrice")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "ingredient_price")
public class IngredientPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "buy_price")
    private double buyPrice;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    public IngredientPrice(double sellPrice, double buyPrice, LocalDate date) {
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.date = date;

    }
}
