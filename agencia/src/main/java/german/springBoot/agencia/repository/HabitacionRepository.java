package german.springBoot.agencia.repository;

import german.springBoot.agencia.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    @Query("SELECT h FROM Habitacion h WHERE h.id NOT IN (SELECT r.habitacion.id FROM Reserva r " +
            "WHERE (:fechaDesde BETWEEN r.fechaEntrada AND r.fechaSalida) " +
            "OR (:fechaHasta BETWEEN r.fechaEntrada AND r.fechaSalida) " +
            "OR (:fechaDesde < r.fechaEntrada AND :fechaHasta > r.fechaSalida)) " +
            "AND h.hotel.ciudad = :destino")
    List<Habitacion> findAvailableRooms(
            @Param("fechaDesde") Date fechaDesde,
            @Param("fechaHasta") Date fechaHasta,
            @Param("destino") String destino
    );
}
