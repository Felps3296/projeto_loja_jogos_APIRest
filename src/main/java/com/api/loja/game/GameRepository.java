package com.api.loja.game;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GameRepository {

    void save(RegisterGame game);
    void update(Long pk_game, UpdateGame game);
    void delete(Long pk_game);;
    List<Game> findAll(Pageable paginacao);
}
