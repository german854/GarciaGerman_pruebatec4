package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Vuelo;
import german.springBoot.agencia.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService implements IVueloService{
    @Autowired
    private VueloRepository vueloRepo;

    public List<Vuelo> obtenerTodosLosVuelos() {
        return vueloRepo.findAll();
    }

    public void saveVuelo(Vuelo vuelo) {
        vueloRepo.save(vuelo);
    }

    public void deleteVuelo(Long id) {
        vueloRepo.deleteById(id);
    }

    public Vuelo findVuelo(Long id) {
        return vueloRepo.findById(id).orElse(null);
    }
    /*
    @Override
    public Vuelo findVueloByNumeroVuelo(String numeroVuelo) {
        //return vueloRepo.findByNombre(nombre).orElse(null);
        return vueloRepo.buscarPorNumeroVuelo(numeroVuelo);
    }*/

}
