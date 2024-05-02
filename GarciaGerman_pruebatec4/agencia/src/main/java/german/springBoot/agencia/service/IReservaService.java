package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Reserva;

import java.util.List;

public interface IReservaService {
    List<Reserva> obtenerTodasLasReservas();
    public void saveReserva(Reserva reserva);
    public void deleteReserva(Long id);
    public Reserva findReserva(Long id);

}
