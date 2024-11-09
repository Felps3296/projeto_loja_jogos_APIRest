package com.api.loja.customer;

import com.api.loja.address.Address;

public record RegisterCustomer(Long pk_customer, String name, String email, String cpf, String phone, Address address) {
}
