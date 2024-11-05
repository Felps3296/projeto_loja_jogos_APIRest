package com.api.loja.game;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class GameDAO implements GameRepository{

    private final JdbcTemplate jdbcTemplate;

    public GameDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(RegisterGame game) {
        String sql = "INSERT INTO games (title, genre, releaseDate, ageRating, price, stock_quantity) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, game.title(), game.genre(), game.releaseDate(), game.ageRating(), game.price(), game.stock_quantity());
    }
}