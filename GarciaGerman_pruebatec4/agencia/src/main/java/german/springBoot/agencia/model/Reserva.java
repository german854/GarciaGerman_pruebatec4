package german.springBoot.agencia.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int cantidadPersonas;
    private double montoTotal;
}
