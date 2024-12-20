package com.api.loja.game;

import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDAO implements GameRepository{

    private final JdbcTemplate jdbcTemplate;

    public GameDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(RegisterGame game) {
        String sql = "INSERT INTO games (title, genre, releaseDate, ageRating, price, stock_quantity) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                game.title(),
                game.genre(),
                game.releaseDate(),
                game.ageRating(),
                game.price(),
                game.stock_quantity());
    }

    @Override
    public List<Game> findAll(Pageable paginacao) {
        String sql = "SELECT pk_game, title, genre, releaseDate, ageRating, price, stock_quantity FROM games";
        return jdbcTemplate.query(sql, new GameRowMapper());
    }

    @Override
    public void update(Long pk_game, UpdateGame game) {
        String sql = "UPDATE games SET title = ?, genre = ?, releaseDate = ?, ageRating = ?, price = ?, stock_quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                game.title(),
                game.genre(),
                game.releaseDate(),
                game.ageRating(),
                game.price(),
                game.stock_quantity(),
                pk_game);
    }

    @Override
    public void delete(Long pk_game) {
        String sql = "DELETE FROM games WHERE pk_game = ?";
        jdbcTemplate.update(sql, pk_game);
    }

    private static class GameRowMapper implements RowMapper<Game> {
        @Override
        public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Game(
                    rs.getLong("pk_game"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getString("releaseDate"),
                    rs.getString("ageRating"),
                    rs.getBigDecimal("price"),
                    rs.getInt("stock_quantity")
            );
        }
    }
}