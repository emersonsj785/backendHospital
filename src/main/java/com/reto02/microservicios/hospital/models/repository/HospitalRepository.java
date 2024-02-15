package com.reto02.microservicios.hospital.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto02.microservicios.hospital.models.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}

