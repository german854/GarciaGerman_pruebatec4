package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Habitacion;

import java.util.Date;
import java.util.List;

public interface IHabitacionService {
    List<Habitacion> obtenerTodasLasHabitaciones();
    List<Habitacion> getHabitacionesDisponibles(Date fechaDesde, Date fechaHasta, String destino);
    public void saveHabitacion(Habitacion habitacion);
    public void deleteHabitacion(Long id);
    public Habitacion findHabitacion(Long id);
}
