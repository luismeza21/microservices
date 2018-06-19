package com.sportime.sportime.controller;

import com.sportime.sportime.exception.ResourceNotFoundException;
import com.sportime.sportime.model.Deporte;
import com.sportime.sportime.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(DeporteController.SPORTIME_BASE_URI)
public class DeporteController {

    public static final String SPORTIME_BASE_URI = "srv/v1/api";

    @Autowired
    public DeporteRepository deporteRepository;


    //Obtener todos los deportes
    @GetMapping("/deportes")
    public List<Deporte> getAllDeportes(){
        return deporteRepository.findAll();
    }

    //crear deportes
    @PostMapping("/deportes")
    public Deporte createDeporte(@Valid @RequestBody Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    //Get un deporte

    @GetMapping("/deportes/{id}")
    public Deporte getDeporteById(@PathVariable(value = "id") Long deporteId) {
        return deporteRepository.findById(deporteId)
                .orElseThrow(() -> new ResourceNotFoundException("Deporte", "id", deporteId));
    }

    //update Deportes
    @PutMapping("/deportes/{id}")
    public Deporte updateDeporte(@PathVariable(value = "id") Long deporteId,
                                 @Valid @RequestBody Deporte deporteDetails) {
        Deporte deporte = deporteRepository.findById(deporteId)
                .orElseThrow(() -> new ResourceNotFoundException("Deporte", "id", deporteId));

        deporte.setCodigo(deporteDetails.getCodigo());
        deporte.setNombre(deporteDetails.getNombre());

        Deporte updateDeporte = deporteRepository.save(deporte);

        return updateDeporte;
    }


    //Eliminar Deporte
    @DeleteMapping("/deportes/{id}")
    public ResponseEntity<Object> deleteDeporte(@PathVariable(value = "id") Long deporteId) {

        Deporte deporte = deporteRepository.findById(deporteId)
                .orElseThrow(() -> new ResourceNotFoundException("Deporte", "id", deporteId));
        deporteRepository.delete(deporte);


        return ResponseEntity.ok().build();


    }

}
