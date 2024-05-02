package german.springBoot.agencia.controller;

import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Reserva;
import german.springBoot.agencia.service.IHotelService;
import german.springBoot.agencia.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/room-booking")
public class ReservaController {
    @Autowired
    private IReservaService reservaService;

    @GetMapping("")
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaService.obtenerTodasLasReservas();
    }

    @PostMapping("/new")
    public String saveReserva(@RequestBody Reserva reserva) {
        reservaService.saveReserva(reserva);
        return "Reserva creada correctamente";
    }
    @DeleteMapping ("/{id}")
    public String deleteReserva (@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return "Reserva eliminada correctamente";
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<Reserva> editReserva (@PathVariable Long id,
                                              @RequestParam ("nombre") String nombreModif){
        //buscamos el hotel a partir de su id
        Reserva reserva = reservaService.findReserva(id);
        if (reserva == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //hotel.setNombre(nombreModif);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
}
