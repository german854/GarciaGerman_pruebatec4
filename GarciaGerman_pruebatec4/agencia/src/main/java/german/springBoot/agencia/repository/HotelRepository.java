package german.springBoot.agencia.repository;

import german.springBoot.agencia.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {


    List<Hotel> findByNombre(String nombre);
}
