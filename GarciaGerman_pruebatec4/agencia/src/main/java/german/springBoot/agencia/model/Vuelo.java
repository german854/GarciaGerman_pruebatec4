package german.springBoot.agencia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroVuelo;
    private String origen;
    private String destino;
    private String tipoAsiento;
    private double precioPorPersona;
    private LocalDate fechaIda;
    private LocalDate fechaVuelta;

    @ManyToMany
    @JoinTable(
            name = "vuelo_pasajero",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "pasajero_id")
    )
    private List<Pasajero> pasajeros;

}
