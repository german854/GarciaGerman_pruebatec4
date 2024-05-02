package german.springBoot.agencia.service;

import german.springBoot.agencia.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> obtenerTodosLosHoteles();
    public void saveHotel(Hotel hotel);
    public void deleteHotel(Long id);
    public Hotel findHotel(Long id);

    List<Hotel> findByNombre(String nombre);

}
