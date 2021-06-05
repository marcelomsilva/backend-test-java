package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Override
    public ResponseEntity<Parking> create(ParkingForm form) {
        return null;
    }

}
