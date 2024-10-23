package com.api.loja.game;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {

    private Long id;
    private String title;
    private String genre;
    private String releaseDate;
    private String ageRating;

    public Game(RegisterGame game){

        this.title = game.title();
        this.id = game.id();
        this.genre = game.genre();
        this.releaseDate = game.releaseDate();
        this.ageRating = game.ageRating();
    }
}
