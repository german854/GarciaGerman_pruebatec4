package german.springBoot.agencia.repository;


import german.springBoot.agencia.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero,Long> {
}
