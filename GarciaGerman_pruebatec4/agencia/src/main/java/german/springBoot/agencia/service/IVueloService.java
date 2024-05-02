package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Vuelo;

import java.util.List;

public interface IVueloService {
    List<Vuelo> obtenerTodosLosVuelos();
    public void saveVuelo(Vuelo vuelo);
    public void deleteVuelo(Long id);
    public Vuelo findVuelo(Long id);
    //public Vuelo findVueloByNumeroVuelo(String numeroVuelo);
}
