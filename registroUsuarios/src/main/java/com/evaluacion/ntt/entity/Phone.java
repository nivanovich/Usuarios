package com.evaluacion.ntt.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Phone implements Serializable{
	private static final long serialVersionUID = 4894729030347835498L;
	@Id
    @GeneratedValue
	private String number;	
	private String cityCode;
	private String countryCode;
	@ManyToOne()
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
