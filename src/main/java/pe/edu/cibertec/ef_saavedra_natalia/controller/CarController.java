package pe.edu.cibertec.ef_saavedra_natalia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ef_saavedra_natalia.dto.CarDto;
import pe.edu.cibertec.ef_saavedra_natalia.response.*;
import pe.edu.cibertec.ef_saavedra_natalia.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public FindCarsResponse findAll(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if(Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = carService.findAllById(Integer.parseInt(id));
                if(optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                } else {
                    return new FindCarsResponse("02", "Car not found", null);
                }
            } else {
                List<CarDto> cars = carService.findAll();
                if(!cars.isEmpty())
                    return new FindCarsResponse("01", "", cars);
                else
                    return new FindCarsResponse("03", "User list not found", cars);
            }
        } catch(Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Service not found", null);
        }
    }

    @GetMapping("/detail")
    public FindCarByIdResponse findById(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if(Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = carService.findById(Integer.parseInt(id));
                if(optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarByIdResponse("01", "", carDto);
                } else {
                    return new FindCarByIdResponse("02", "Car not found", null);
                }
            } else {
                return new FindCarByIdResponse("03", "Parameter not found", null);
            }
        } catch(Exception e) {
            e.printStackTrace();
            return new FindCarByIdResponse("99", "Service not found", null);
        }
    }

    @PutMapping("/update")
    public UpdateCarResponse update(@RequestBody CarDto carDto) {
        try {
            if(carService.update(carDto)) {
                return new UpdateCarResponse("01", "");
            } else {
                return new UpdateCarResponse("02", "Car not found");
            }
        } catch(Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Service not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse delete(@PathVariable("id") String id) {
        try {
            if(carService.deleteById(Integer.parseInt(id))) {
                return new DeleteCarResponse("01", "");
            } else {
                return new DeleteCarResponse("02", "Car not found");
            }
        } catch(Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Service not found");
        }
    }

    @PostMapping("/create")
    public CreateCarResponse create(@RequestBody CarDto carDto) {
        try {
            if(carService.create(carDto)) {
                return new CreateCarResponse("01", "");
            } else {
                return new CreateCarResponse("04", "Unknown Error");
            }
        } catch(Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Service not found");
        }
    }
}
