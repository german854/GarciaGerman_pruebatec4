package german.springBoot.agencia.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private int capacidad;
    private double precioPorNoche;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
