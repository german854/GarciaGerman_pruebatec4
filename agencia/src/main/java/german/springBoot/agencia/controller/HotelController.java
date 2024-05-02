package german.springBoot.agencia.controller;

import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.service.HotelService;
import german.springBoot.agencia.service.IHotelService;
import german.springBoot.agencia.service.IVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/hotels")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @GetMapping("")
    public List<Hotel> obtenerTodosLosHoteles() {
        return hotelService.obtenerTodosLosHoteles();
    }

    @PostMapping("/ingresarHoteles")
    public String saveHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "Hotel creado correctamente";
    }
    @DeleteMapping ("/borrar/{id}")
    public String deleteHotel (@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return "Hotel eliminado correctamente";
    }
    /* SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La operación se ejecutó correctamente"),
            @ApiResponse(responseCode = "204", description = "No se encontró la persona que intenta editar")
    })*/

    @PutMapping ("/editar/{id}")
    public ResponseEntity<Hotel> editPersona (@PathVariable Long id,
                                              @RequestParam ("nombre") String nombreModif){
        //buscamos el hotel a partir de su id
        Hotel hotel = hotelService.findHotel(id);
        if (hotel == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        hotel.setNombre(nombreModif);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/buscarHoteles")
    public List<Hotel> buscarHotelesPorNombre(@RequestParam String nombre) {
        return hotelService.findByNombre(nombre);
    }

}
