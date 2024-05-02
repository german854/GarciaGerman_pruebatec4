package german.springBoot.agencia.controller;

import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Pasajero;
import german.springBoot.agencia.service.IHotelService;
import german.springBoot.agencia.service.IPasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/pasajeros")
public class PasajeroController {
    @Autowired
    private IPasajeroService pasajeroService;

    @GetMapping("/obtenerPasajeros")
    public List<Pasajero> obtenerTodosLosPasajeros() {
        return pasajeroService.obtenerTodosLosPasajeros();
    }

    @PostMapping("/ingresarPasajeros")
    public String savePasajero(@RequestBody Pasajero pasajero) {
        pasajeroService.savePasajero(pasajero);
        return "Pasajero creado correctamente";
    }
    @DeleteMapping ("/borrar/{id}")
    public String deletePasajero (@PathVariable Long id) {
        pasajeroService.deletePasajero(id);
        return "Pasajero eliminado correctamente";
    }
    /* SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La operación se ejecutó correctamente"),
            @ApiResponse(responseCode = "204", description = "No se encontró la persona que intenta editar")
    })*/

    @PutMapping ("/editar/{id}")
    public ResponseEntity<Pasajero> editPersona (@PathVariable Long id,
                                              @RequestParam ("nombre") String nombreModif){
        //buscamos el hotel a partir de su id
        Pasajero pasajero = pasajeroService.findPasajero(id);
        if (pasajero == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        pasajero.setNombre(nombreModif);
        return new ResponseEntity<>(pasajero, HttpStatus.OK);
    }
}
