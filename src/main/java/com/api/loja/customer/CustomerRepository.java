package com.api.loja.customer;

import com.api.loja.address.AddressDTO;

public interface CustomerRepository {

    void save(RegisterCustomer registerCustomer);
}
