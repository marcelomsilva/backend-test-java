package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressServiceImpl implements AddressService {

    @Override
    public Address getByZipCode(String zipcode) {
        if(verifyZipCodeFormat(zipcode))
            return new RestTemplate().getForObject("https://viacep.com.br/ws/" + zipcode + "/json/", Address.class);
        else throw new IllegalArgumentException("O CEP deve ter 8 digitos e nao pode conter letras");
    }

    private boolean verifyZipCodeFormat(String zipcode) {
        if(zipcode.length() == 8)
            if(!zipcode.substring(0, zipcode.length()).matches("[A-Z]*"))
                return true;
        return false;
    }
}
