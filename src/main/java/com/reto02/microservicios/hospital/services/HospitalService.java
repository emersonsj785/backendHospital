package com.reto02.microservicios.hospital.services;

import java.util.List;

import com.reto02.microservicios.hospital.models.entity.Hospital;
import com.reto02.microservicios.hospital.models.entity.HospitalDTO;

public interface HospitalService {
    List<HospitalDTO> listarHospitalesPorId(int tipo, Long id);
    String registrarHospitalConSP(Hospital hospital);
    List<HospitalDTO> listarHospitalVer(Long id);
    
    String actualizarHospitalConSP(Hospital hospital);
    String eliminarHospitalConSP(Long idHospital);
}



