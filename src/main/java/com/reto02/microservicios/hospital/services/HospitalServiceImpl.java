package com.reto02.microservicios.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto02.microservicios.hospital.models.entity.Hospital;
import com.reto02.microservicios.hospital.models.entity.HospitalDTO;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
    private EntityManager entityManager;

	@Override
	public List<HospitalDTO> listarHospitalesPorId(int tipo, Long id) {
	    StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_LISTAR");
	    storedProcedure.registerStoredProcedureParameter("in_tipo", Integer.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("in_id", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("hospital_refcur", void.class, ParameterMode.REF_CURSOR);

	    storedProcedure.setParameter("in_tipo", tipo);
	    storedProcedure.setParameter("in_id", id);

	    List<HospitalDTO> resultList = new ArrayList<>();
	    try {
	        storedProcedure.execute();
	        ResultSet resultSet = (ResultSet) storedProcedure.getOutputParameterValue("hospital_refcur");
	        while (resultSet.next()) {
	            HospitalDTO hospitalDTO = new HospitalDTO();
	            hospitalDTO.setIdHospital(resultSet.getLong("idHospital"));
	            hospitalDTO.setNombre(resultSet.getString("nombre"));
	            hospitalDTO.setAntiguedad(resultSet.getInt("antiguedad"));
	            hospitalDTO.setArea(resultSet.getDouble("area"));
	            hospitalDTO.setIdDistrito(resultSet.getLong("idDistrito"));
	            hospitalDTO.setDescDistrito(resultSet.getString("descDistrito"));
	            hospitalDTO.setIdSede(resultSet.getLong("idSede"));
	            hospitalDTO.setDescSede(resultSet.getString("descSede"));
	            hospitalDTO.setIdGerente(resultSet.getLong("idGerente"));
	            hospitalDTO.setDescGerente(resultSet.getString("descGerente"));
	            hospitalDTO.setIdCondicion(resultSet.getLong("idCondicion"));
	            hospitalDTO.setDescCondicion(resultSet.getString("descCondicion"));
	            hospitalDTO.setFechaRegistro(resultSet.getDate("fechaRegistro"));
	            resultList.add(hospitalDTO);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return resultList;
	}

	
	@Override
	public List<HospitalDTO> listarHospitalVer(Long id) {
	    StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_VER");
	    storedProcedure.registerStoredProcedureParameter("in_idHospital", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("hospital_refcur", void.class, ParameterMode.REF_CURSOR);
	    
	    storedProcedure.setParameter("in_idHospital", id);

	    List<HospitalDTO> resultList = new ArrayList<>();
	    try {
	        storedProcedure.execute();
	        ResultSet resultSet = (ResultSet) storedProcedure.getOutputParameterValue("hospital_refcur");
	        while (resultSet.next()) {
	            HospitalDTO hospitalDTO = new HospitalDTO();
	            hospitalDTO.setIdHospital(resultSet.getLong("idHospital"));
	            hospitalDTO.setNombre(resultSet.getString("nombre"));
	            hospitalDTO.setAntiguedad(resultSet.getInt("antiguedad"));
	            hospitalDTO.setArea(resultSet.getDouble("area"));
	            hospitalDTO.setIdDistrito(resultSet.getLong("idDistrito"));
	            hospitalDTO.setDescDistrito(resultSet.getString("descDistrito"));
	            hospitalDTO.setIdSede(resultSet.getLong("idSede"));
	            hospitalDTO.setDescSede(resultSet.getString("descSede"));
	            hospitalDTO.setIdGerente(resultSet.getLong("idGerente"));
	            hospitalDTO.setDescGerente(resultSet.getString("descGerente"));
	            hospitalDTO.setIdCondicion(resultSet.getLong("idCondicion"));
	            hospitalDTO.setDescCondicion(resultSet.getString("descCondicion"));
	            hospitalDTO.setFechaRegistro(resultSet.getDate("fechaRegistro"));
	            resultList.add(hospitalDTO);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}

	
	@Override
	public String registrarHospitalConSP(Hospital hospital) {
	    StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_REGISTRAR");
	    storedProcedure.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_antiguedad", Integer.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idDistrito", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_area", Double.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idSede", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idGerente", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idCondicion", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_fechaRegistro", Date.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("v_mensaje", String.class, ParameterMode.OUT);
	    storedProcedure.registerStoredProcedureParameter("hospital_refcur", void.class, ParameterMode.REF_CURSOR);

	    try {
	        storedProcedure.setParameter("p_nombre", hospital.getNombre());
	        storedProcedure.setParameter("p_antiguedad", hospital.getAntiguedad());
	        storedProcedure.setParameter("p_idDistrito", hospital.getIdDistrito());
	        storedProcedure.setParameter("p_area", hospital.getArea());
	        storedProcedure.setParameter("p_idSede", hospital.getIdSede());
	        storedProcedure.setParameter("p_idGerente", hospital.getIdGerente());
	        storedProcedure.setParameter("p_idCondicion", hospital.getIdCondicion());
	        storedProcedure.setParameter("p_fechaRegistro", hospital.getFechaRegistro());

	        storedProcedure.execute();
	        return (String) storedProcedure.getOutputParameterValue("v_mensaje");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error al actualizar el hospital";
	    }
	}
	
	@Override
	@Transactional
	public String actualizarHospitalConSP(Hospital hospital) {
	    StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_ACTUALIZAR");
	    storedProcedure.registerStoredProcedureParameter("p_idHospital", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_antiguedad", Integer.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idDistrito", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_area", Double.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idSede", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idGerente", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_idCondicion", Long.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("p_fechaRegistro", Date.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("v_mensaje", String.class, ParameterMode.OUT);

	    try {
	        storedProcedure.setParameter("p_idHospital", hospital.getIdHospital());
	        storedProcedure.setParameter("p_nombre", hospital.getNombre());
	        storedProcedure.setParameter("p_antiguedad", hospital.getAntiguedad());
	        storedProcedure.setParameter("p_idDistrito", hospital.getIdDistrito());
	        storedProcedure.setParameter("p_area", hospital.getArea());
	        storedProcedure.setParameter("p_idSede", hospital.getIdSede());
	        storedProcedure.setParameter("p_idGerente", hospital.getIdGerente());
	        storedProcedure.setParameter("p_idCondicion", hospital.getIdCondicion());
	        storedProcedure.setParameter("p_fechaRegistro", hospital.getFechaRegistro());

	        storedProcedure.execute();
	        return (String) storedProcedure.getOutputParameterValue("v_mensaje");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error al actualizar el hospital";
	    }
	}

	@Override
    @Transactional
    public String eliminarHospitalConSP(Long idHospital) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_ELIMINAR");
        storedProcedure.registerStoredProcedureParameter("p_hospital", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("v_mensaje", String.class, ParameterMode.OUT);

        try {
            storedProcedure.setParameter("p_hospital", idHospital);
            storedProcedure.execute();
            return (String) storedProcedure.getOutputParameterValue("v_mensaje");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el hospital";
        }
    }
}



