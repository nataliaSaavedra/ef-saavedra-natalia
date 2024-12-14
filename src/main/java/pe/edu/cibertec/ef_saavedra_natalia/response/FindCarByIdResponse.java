package pe.edu.cibertec.ef_saavedra_natalia.response;

import pe.edu.cibertec.ef_saavedra_natalia.dto.CarDto;

public record FindCarByIdResponse(String code,
                                  String error,
                                  CarDto carDto) {
}
