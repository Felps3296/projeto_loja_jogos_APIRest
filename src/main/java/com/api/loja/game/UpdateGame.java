package com.api.loja.game;

import java.math.BigDecimal;

public record UpdateGame(Long pk_game, String title, String genre, String releaseDate, String ageRating, BigDecimal price, int stock_quantity ) {

}
