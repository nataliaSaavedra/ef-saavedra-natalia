package pe.edu.cibertec.ef_saavedra_natalia.response;

import pe.edu.cibertec.ef_saavedra_natalia.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
