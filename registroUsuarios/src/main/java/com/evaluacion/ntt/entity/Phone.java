package com.evaluacion.ntt.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Entity
public class Phone implements Serializable{
	private static final long serialVersionUID = 4894729030347835498L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
	@Getter @Setter private Long id;
	@Column(name = "NUMBER", unique = false, nullable = true, length = 15)
	@Getter @Setter private String number;	
	@Column(name = "CITY_CODE", unique = false, nullable = true, length = 4)
	@Getter @Setter private String cityCode;
	@Column(name = "COUNTRY_CODE", unique = false, nullable = true, length = 4)
	@Getter @Setter private String countryCode;
	@ManyToOne
	@Getter @Setter private Usuario usuario;
	

}
