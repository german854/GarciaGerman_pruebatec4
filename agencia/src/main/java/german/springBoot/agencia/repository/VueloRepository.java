package german.springBoot.agencia.repository;

import german.springBoot.agencia.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    /*
    Optional<Vuelo> findByNumeroVuelo(String vuelo);

    @Query("SELECT p FROM Vuelo p where p.numeroVuelo = ?1")
    Vuelo buscarPorNumeroVuelo(String nombre);*/
}
