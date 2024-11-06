package com.api.loja.game;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface GameRepository {

    void save(RegisterGame game);
    void update(Long id, UpdateGame game);
    void delete(Long id);;
    List<Game> findAll(Pageable paginacao);
}
