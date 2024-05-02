package german.springBoot.agencia.controller;


import german.springBoot.agencia.model.Hotel;
import german.springBoot.agencia.model.Vuelo;
import german.springBoot.agencia.service.IVueloService;
import german.springBoot.agencia.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class VueloController {

    @Autowired
    private IVueloService vueloService;

    @GetMapping("")
    public List<Vuelo> obtenerTodosLosVuelos() {
        return vueloService.obtenerTodosLosVuelos();
    }

    @PostMapping("/new")
    public String saveVuelo(@RequestBody Vuelo vuelo, @RequestParam int cantidadPersonas) {
        double precioTotal = vuelo.getPrecioPorPersona() * cantidadPersonas;
        vueloService.saveVuelo(vuelo);
        return "Vuelo creado correctamente, el precio total de la reserva es: " + precioTotal + " €";
    }
    @DeleteMapping ("/delete/{id}")
    public String deleteVuelo (@PathVariable Long id) {
        vueloService.deleteVuelo(id);
        return "Vuelo eliminado correctamente";
    }

    @PutMapping ("/edit/{id}")
    public ResponseEntity<Vuelo> editVuelo (@PathVariable Long id,
                                              @RequestParam ("numeroVuelo") String numeroVueloModif){
        //buscamos el vuelo a partir de su id
        Vuelo vuelo = vueloService.findVuelo(id);
        if (vuelo == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        vuelo.setNumeroVuelo(numeroVueloModif);
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }

}
