package com.evaluacion.ntt.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Phone implements Serializable{
	private static final long serialVersionUID = 4894729030347835498L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
	@Column(name = "NUMBER", unique = false, nullable = true, length = 15)
	private String number;	
	@Column(name = "CITY_CODE", unique = false, nullable = true, length = 4)
	private String cityCode;
	@Column(name = "COUNTRY_CODE", unique = false, nullable = true, length = 4)
	private String countryCode;
	@ManyToOne
    private Usuario usuario;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Phone [number=" + number + ", cityCode=" + cityCode + ", countryCode=" + countryCode + "]";
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
