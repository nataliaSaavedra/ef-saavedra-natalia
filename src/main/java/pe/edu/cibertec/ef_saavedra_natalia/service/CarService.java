package pe.edu.cibertec.ef_saavedra_natalia.service;

import pe.edu.cibertec.ef_saavedra_natalia.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDto> findAll() throws Exception;
    Optional<CarDto> findAllById(Integer id) throws Exception;
    Optional<CarDto> findById(Integer id) throws Exception;
    Boolean update(CarDto carDto) throws Exception;
    Boolean deleteById(Integer id) throws Exception;
    Boolean create(CarDto carDto);
}
