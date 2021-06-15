package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Address;

public interface AddressService {

    Address getByZipCode(String zipcode);
}
