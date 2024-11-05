package com.api.loja.game;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameRepository {

    void save(RegisterGame game);
    List<Game> findAll(Pageable paginacao);
    void update(Long id, UpdateGame game);
    void delete(Long id);
}
