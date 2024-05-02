package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Pasajero;

import java.util.List;

public interface IPasajeroService {
    List<Pasajero> obtenerTodosLosPasajeros();
    public void savePasajero(Pasajero pasajero);
    public void deletePasajero(Long id);
    public Pasajero findPasajero(Long id);
}
