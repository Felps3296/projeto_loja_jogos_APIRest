package com.api.loja.address;


public record AddressDTO(

        String street,
        String neighborhood,
        String city,
        String state,
        String zip,
        Long fk_customer) {
}
