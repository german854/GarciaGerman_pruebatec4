package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Reserva;
import german.springBoot.agencia.repository.HotelRepository;
import german.springBoot.agencia.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService implements IReservaService{
    @Autowired
    private ReservaRepository reservaRepo;
    public List<Reserva> obtenerTodasLasReservas() {return reservaRepo.findAll();    }

    public void saveReserva(Reserva reserva) {
        reservaRepo.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservaRepo.deleteById(id);
    }

    public Reserva findReserva(Long id) {
        return reservaRepo.findById(id).orElse(null);
    }
}
