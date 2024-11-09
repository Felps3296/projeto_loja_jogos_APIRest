package com.api.loja.customer;

import com.api.loja.address.Address;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pk_customer")
public class Customer {

    private Long pk_customer;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Address address;

    public Customer(RegisterCustomer customer) {

        this.pk_customer = customer.pk_customer();
        this.name = customer.name();
        this.email = customer.email();
        this.cpf = customer.cpf();
        this.phone = customer.phone();
        this.address = customer.address();
    }
}
