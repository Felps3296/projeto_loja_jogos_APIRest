package com.api.loja.game;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterGame(

        Long id,
        @NotBlank
        String title,
        @NotBlank
        String genre,
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$")
        String releaseDate,
        @NotBlank
        String ageRating) {

}
