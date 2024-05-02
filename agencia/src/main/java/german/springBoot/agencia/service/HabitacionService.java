package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Habitacion;
import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.repository.HabitacionRepository;
import german.springBoot.agencia.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HabitacionService implements IHabitacionService{
    @Autowired
    private HabitacionRepository habitacionRepo;
    public List<Habitacion> obtenerTodasLasHabitaciones() {
        return habitacionRepo.findAll();
    }
    public List<Habitacion> getHabitacionesDisponibles(Date fechaDesde, Date fechaHasta, String destino) {
        return habitacionRepo.findAvailableRooms(fechaDesde, fechaHasta, destino);
    }

    public void saveHabitacion(Habitacion habitacion) {
        habitacionRepo.save(habitacion);
    }

    public void deleteHabitacion(Long id) {
        habitacionRepo.deleteById(id);
    }

    public Habitacion findHabitacion(Long id) {
        return habitacionRepo.findById(id).orElse(null);
    }

}
