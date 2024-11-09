package com.api.loja.address;

import com.api.loja.customer.Customer;
import com.api.loja.customer.RegisterCustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address{

    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String zip;
    private Long fk_customer;

    public Address(AddressDTO address) {

        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.state = address.state();
        this.zip = address.zip();
        this.fk_customer = getFk_customer();
    }

    public void AddressUpdate(AddressDTO address) {

        if(address.street() != null){
            this.street = address.street();
        }

        if(address.neighborhood() != null){
            this.neighborhood = address.neighborhood();
        }

        if(address.city() != null){
            this.city = address.city();
        }

        if(address.state() != null){
            this.state = address.state();
        }

        if(address.zip() != null){
            this.zip = address.zip();
        }
    }
}
