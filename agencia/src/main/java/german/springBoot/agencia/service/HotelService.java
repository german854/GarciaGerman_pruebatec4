package german.springBoot.agencia.service;

import german.springBoot.agencia.config.NotFoundException;
import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Vuelo;
import german.springBoot.agencia.repository.HotelRepository;
import german.springBoot.agencia.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements IHotelService{
    @Autowired
    private HotelRepository hotelRepo;
    public List<Hotel> obtenerTodosLosHoteles() {
        return hotelRepo.findAll();
    }

    public void saveHotel(Hotel hotel) {
        hotelRepo.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepo.deleteById(id);
    }

    public Hotel findHotel(Long id) {
        return hotelRepo.findById(id).orElse(null);
    }


    public Hotel findHotelById(Long id) {
        Optional<Hotel> optionalHotel = hotelRepo.findById(id);
        if (optionalHotel.isPresent()) {
            return optionalHotel.get();
        } else {
            throw new NotFoundException("El hotel con ID " + id + " no existe.");
        }
    }

    public List<Hotel> findByNombre(String nombre) {
        List<Hotel> hoteles = hotelRepo.findByNombre(nombre);

        if (hoteles.isEmpty()) {
            throw new NotFoundException("No se encontraron hoteles con el nombre " + nombre);
        }

        return hoteles;
    }

}
