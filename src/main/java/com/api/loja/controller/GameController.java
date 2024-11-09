package com.api.loja.controller;

import com.api.loja.game.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameDAO gameDAO;

    // Injeção de dependência do DAO (que usa JdbcTemplate)
    public GameController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid RegisterGame game){

        gameDAO.save(game);
        return ResponseEntity.status(HttpStatus.CREATED).body("Game saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<Game>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {

        List<Game> gamesPage = gameDAO.findAll(paginacao);
        return ResponseEntity.ok(gamesPage);
    }

    @PutMapping("/{pk_game}")
    public ResponseEntity<DetailsGame> update(@PathVariable Long pk_game, @RequestBody UpdateGame game){

        gameDAO.update(pk_game, game);
        return ResponseEntity.ok(new DetailsGame(game));
    }

    @DeleteMapping("/{pk_game}")
    public ResponseEntity<String> delete(@PathVariable Long pk_game){

        gameDAO.delete(pk_game);
        return ResponseEntity.noContent().build();
    }
}

