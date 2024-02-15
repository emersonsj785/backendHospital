package com.reto02.microservicios.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reto02.microservicios.hospital.models.entity.FiltroHospital;
import com.reto02.microservicios.hospital.models.entity.Hospital;
import com.reto02.microservicios.hospital.models.entity.HospitalDTO;
import com.reto02.microservicios.hospital.services.HospitalService;
import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/filtrado")
    public List<HospitalDTO> listarHospitales(@RequestBody FiltroHospital filtro) {
        return hospitalService.listarHospitalesPorId(filtro.getTipo(), filtro.getId());
    }
    
    @PostMapping("/ver")
    public List<HospitalDTO> hospitalVer(@RequestBody FiltroHospital filtro) {
        return hospitalService.listarHospitalVer(filtro.getId());
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarHospital(@RequestBody Hospital hospital) {
        String mensaje = hospitalService.registrarHospitalConSP(hospital);
        return ResponseEntity.ok().body("{\"mensaje\": \"" + mensaje + "\"}");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarHospital(@PathVariable Long id, @RequestBody Hospital hospital) {
        hospital.setIdHospital(id);
        String mensaje = hospitalService.actualizarHospitalConSP(hospital);
        return ResponseEntity.ok().body("{\"mensaje\": \"" + mensaje + "\"}");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHospital(@PathVariable("id") Long idHospital) {
        String mensaje = hospitalService.eliminarHospitalConSP(idHospital);
        return ResponseEntity.ok().body("{\"mensaje\": \"" + mensaje + "\"}");
    }
}


