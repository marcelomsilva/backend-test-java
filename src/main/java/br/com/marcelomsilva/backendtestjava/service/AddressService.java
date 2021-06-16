package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Address;

public interface AddressService {

    Address getByZipCodeApiViaCep(String zipcode);
    Address build(String zipcode, String publicPlace, String number, String city, String state, String neighborhood, String complement);
}
