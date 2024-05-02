package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Pasajero;
import german.springBoot.agencia.repository.HotelRepository;
import german.springBoot.agencia.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService implements IPasajeroService{
    @Autowired
    private PasajeroRepository pasajeroRepo;
    public List<Pasajero> obtenerTodosLosPasajeros() {
        return pasajeroRepo.findAll();
    }

    public void savePasajero(Pasajero pasajero) {
        pasajeroRepo.save(pasajero);
    }

    public void deletePasajero(Long id) {
        pasajeroRepo.deleteById(id);
    }

    public Pasajero findPasajero(Long id) {
        return pasajeroRepo.findById(id).orElse(null);
    }
/*
    public Pasajero findHotelByPasajero(String pasajero) {
        //return nombreRepo.findByNombre(nombre).orElse(null);
        return pasajeroRepo.buscarPorNombre(nombre);
    }*/
}
