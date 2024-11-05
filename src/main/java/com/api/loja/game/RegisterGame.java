package com.api.loja.game;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record RegisterGame(

        Long id,
        @NotBlank
        String title,
        @NotBlank
        String genre,
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$")
        String releaseDate,
        @NotBlank
        String ageRating,
        @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
        @Digits(integer = 6, fraction = 2, message = "O preço deve ter no máximo 6 dígitos inteiros e 2 decimais.")
        BigDecimal price,
        @Min(0)
        int stock_quantity) {
}
