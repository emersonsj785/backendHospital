package com.reto02.microservicios.hospital.models.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "HOSPITAL")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHospital")
    private Long idHospital;

    private String nombre;

    private Integer antiguedad;
    
    private Double area;

    private Long idDistrito;

    private Long idSede;

    private Long idGerente;

    private Long idCondicion;
    
    private String descDistrito;
    private String descSede;
    private String descGerente;
    private String descCondicion;

    private Date fechaRegistro;

	public Long getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(Long idHospital) {
		this.idHospital = idHospital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public Long getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(Long idGerente) {
		this.idGerente = idGerente;
	}

	public Long getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(Long idCondicion) {
		this.idCondicion = idCondicion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getDescDistrito() {
		return descDistrito;
	}

	public void setDescDistrito(String descDistrito) {
		this.descDistrito = descDistrito;
	}

	public String getDescSede() {
		return descSede;
	}

	public void setDescSede(String descSede) {
		this.descSede = descSede;
	}

	public String getDescGerente() {
		return descGerente;
	}

	public void setDescGerente(String descGerente) {
		this.descGerente = descGerente;
	}

	public String getDescCondicion() {
		return descCondicion;
	}

	public void setDescCondicion(String descCondicion) {
		this.descCondicion = descCondicion;
	}

	

    
}


