package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingUpdateForm;
import br.com.marcelomsilva.backendtestjava.entity.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressServiceImpl implements AddressService {

    @Override
    public Address getByZipCodeApiViaCep(String zipcode) {
        verifyZipCodeFormat(zipcode);
        return new RestTemplate().getForObject("https://viacep.com.br/ws/" + zipcode + "/json/", Address.class);
    }

    @Override
    public Address build(String zipcode, String publicPlace, String number, String city, String state, String neighborhood, String complement) {
        Address address = getByZipCodeApiViaCep(zipcode);
        if(address.getZipcode() != null) {
            address.setNumber(number);
            address.setComplement(complement);
            return address;
        }
        return new Address(zipcode, publicPlace, number, city, state, neighborhood, complement);
    }

    @Override
    public Address update(Address address, ParkingUpdateForm form) {
        Address newAddress = getByZipCodeApiViaCep(form.getZipCode());
        if(newAddress.getZipcode() != null) {
            newAddress = setAttributes(address, newAddress);
            newAddress.setNumber(form.getNumber());
            newAddress.setComplement(form.getComplement());
            return newAddress;
        }
        return setAttributes(address, form);
    }

    private Address setAttributes(Address address, Address newAddress) {
        address.setZipcode(newAddress.getZipcode());
        address.setPublicPlace(newAddress.getPublicPlace());
        address.setCity(newAddress.getCity());
        address.setState(newAddress.getState());
        address.setNeighborhood(newAddress.getNeighborhood());
        return address;
    }

    private Address setAttributes(Address address, ParkingUpdateForm form) {
        address.setZipcode(form.getZipCode());
        address.setPublicPlace(form.getPublicPlace());
        address.setCity(form.getCity());
        address.setState(form.getState());
        address.setNeighborhood(form.getNeighborhood());
        address.setNumber(form.getNumber());
        address.setComplement(form.getComplement());
        return address;
    }

    private boolean verifyZipCodeFormat(String zipcode) {
        if(zipcode != null) {
            if(zipcode.length() == 8)
                if(!zipcode.substring(0, zipcode.length()).matches("[A-Z]*"))
                    return true;
        }
        throw new IllegalArgumentException("O CEP deve ter 8 digitos e nao pode conter letras");
    }
}
