package german.springBoot.agencia.controller;

import german.springBoot.agencia.model.Habitacion;
import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.service.IHabitacionService;
import german.springBoot.agencia.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/agency/rooms")
public class HabitacionController {
    @Autowired
    private IHabitacionService habitacionService;

    @GetMapping("/obtenerHabitaciones")
    public List<Habitacion> obtenerTodasLasHabitaciones() {
        return habitacionService.obtenerTodasLasHabitaciones();
    }

    @GetMapping("")
    public List<Habitacion> getHabitacionesDisponibles(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaDesde,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaHasta,
            @RequestParam("destination") String destino) {
        return habitacionService.getHabitacionesDisponibles(fechaDesde, fechaHasta, destino);
    }


    @PostMapping("/ingresarHabitaciones")
    public String saveHabitacion(@RequestBody Habitacion habitacion) {
        habitacionService.saveHabitacion(habitacion);
        return "Habitacion creada correctamente";
    }
    @DeleteMapping ("/borrar/{id}")
    public String deleteHabitacion (@PathVariable Long id) {
        habitacionService.deleteHabitacion(id);
        return "Habitacion eliminada correctamente";
    }
    /* SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La operación se ejecutó correctamente"),
            @ApiResponse(responseCode = "204", description = "No se encontró la persona que intenta editar")
    })*/

    @PutMapping ("/editar/{id}")
    public ResponseEntity<Habitacion> editHabitacion (@PathVariable Long id,
                                              @RequestParam ("nombre") String nombreModif){
        //buscamos la habitacion a partir de su id
        Habitacion habitacion = habitacionService.findHabitacion(id);
        if (habitacion == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //habitacion.setNombre(nombreModif);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }
}
