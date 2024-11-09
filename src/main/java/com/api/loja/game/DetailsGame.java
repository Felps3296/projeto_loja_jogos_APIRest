package com.api.loja.game;

import java.math.BigDecimal;

public record DetailsGame(String title, String genre, String releaseDate, String ageRating, BigDecimal price, int stock_quantity) {

    public DetailsGame(UpdateGame game) {

        this(game.title(), game.genre(), game.releaseDate(), game.ageRating(), game.price(), game.stock_quantity());
    }
}
