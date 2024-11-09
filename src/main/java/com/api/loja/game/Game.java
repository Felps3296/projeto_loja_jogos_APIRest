package com.api.loja.game;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pk_game")
public class Game {

    private Long pk_game;
    private String title;
    private String genre;
    private String releaseDate;
    private String ageRating;
    private BigDecimal price;
    private int stock_quantity;

    public Game(RegisterGame game){

        this.pk_game = game.pk_game();
        this.title = game.title();
        this.genre = game.genre();
        this.releaseDate = game.releaseDate();
        this.ageRating = game.ageRating();
        this.price = game.price();
        this.stock_quantity = game.stock_quantity();
    }
}
