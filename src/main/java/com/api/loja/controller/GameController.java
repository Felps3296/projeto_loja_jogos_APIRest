package com.api.loja.controller;

import com.api.loja.game.GameDAO;
import com.api.loja.game.RegisterGame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameDAO gameDAO;

    // Injeção de dependência do DAO (que usa JdbcTemplate)
    public GameController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterGame game){

        gameDAO.save(game);
        return ResponseEntity.ok("Game saved successfully");
    }
}
